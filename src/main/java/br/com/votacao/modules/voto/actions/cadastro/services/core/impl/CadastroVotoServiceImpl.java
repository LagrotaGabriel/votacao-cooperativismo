package br.com.votacao.modules.voto.actions.cadastro.services.core.impl;

import br.com.votacao.modules.associado.entity.AssociadoEntity;
import br.com.votacao.modules.associado.repository.AssociadoRepository;
import br.com.votacao.modules.pauta.entity.PautaEntity;
import br.com.votacao.modules.pauta.repository.PautaRepository;
import br.com.votacao.modules.voto.actions.cadastro.dto.request.CadastroVotoRequest;
import br.com.votacao.modules.voto.actions.cadastro.dto.response.CadastroVotoResponse;
import br.com.votacao.modules.voto.actions.cadastro.services.core.CadastroVotoService;
import br.com.votacao.modules.voto.actions.cadastro.services.core.exceptions.AssociadoNaoEncontradoException;
import br.com.votacao.modules.voto.actions.cadastro.services.core.exceptions.PautaNaoEncontradaException;
import br.com.votacao.modules.voto.actions.cadastro.services.mapper.CadastroVotoMapperService;
import br.com.votacao.modules.voto.actions.cadastro.services.validator.CadastroVotoValidatorService;
import br.com.votacao.modules.voto.entity.VotoEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * CadastroVotoServiceImpl
 * Service responsável por realizar o cadastro de um novo voto
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 17:12
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CadastroVotoServiceImpl implements CadastroVotoService {

    private final CadastroVotoValidatorService validatorService;
    private final CadastroVotoMapperService mapperService;

    private final PautaRepository pautaRepository;
    private final AssociadoRepository associadoRepository;

    @Override
    public CadastroVotoResponse realizaCadastroDeNovoVoto(UUID idPauta,
                                                          CadastroVotoRequest cadastroVotoRequest) {

        log.debug("Metodo responsavel por realizar o cadastro de um novo voto acessado");
        log.trace("idPauta: {}", idPauta);
        log.trace("cadastroVotoRequest: {}", cadastroVotoRequest);

        log.debug("Iniciando busca pela pauta da votacao por id...");
        PautaEntity pautaEncontrada =
                pautaRepository.findById(idPauta).orElseThrow(
                        () -> {
                            log.warn("Nenhuma pauta foi encontrada atraves do id informado: {}", idPauta);
                            return new PautaNaoEncontradaException("Nenhuma pauta foi encontrada com o id informado");
                        }
                );
        log.debug("Busca pela pauta da votacao por id realizada com sucesso");
        log.trace("pautaEncontrada: {}", pautaEncontrada);

        log.debug("Iniciando busca pelo associado responsavel pelo voto por id...");
        AssociadoEntity associadoEncontrado =
                associadoRepository.findById(cadastroVotoRequest.idAssociado()).orElseThrow(
                        () -> {
                            log.warn("Nenhum associado foi encontrado atraves do id informado: {}", cadastroVotoRequest.idAssociado());
                            return new AssociadoNaoEncontradoException("Nenhum associado foi encontrado com o id informado");
                        }
                );
        log.debug("Busca pelo associado responsavel pelo voto por id realizada com sucesso");
        log.trace("associadoEncontrado: {}", associadoEncontrado);

        log.debug("Iniciando acesso ao metodo responsavel por realizar as validacoes do voto...");
        validatorService.realizaValidacoesDoCadastroDeVoto(
                pautaEncontrada,
                cadastroVotoRequest.idAssociado()
        );
        log.debug("Acesso ao metodo responsavel por realizar as validacoes do voto finalizado");

        log.debug("Iniciando acesso ao metodo responsavel por realizar a criacao de VotoEntity a partir de CadastroVotoRequest...");
        VotoEntity votoEntity =
                mapperService.geraVotoEntityAPartirDeCadastroVotoRequest(
                        cadastroVotoRequest,
                        associadoEncontrado
                );
        log.debug("Acesso ao metodo responsavel por realizar a criacao de VotoEntity a partir de CadastroVotoRequest finalizado");
        log.trace("votoEntity: {}", votoEntity);

        log.debug("Acoplando VotoEntity gerado na lista de votos da pauta...");
        pautaEncontrada.getVotos().add(votoEntity);
        log.debug("VotoEntity gerado acoplado na lista de votos da pauta");
        log.trace("pautaEncontrada: {}", pautaEncontrada);

        log.debug("Iniciando persistencia da pauta atualizada com o novo voto no banco de dados...");
        PautaEntity pautaAtualizadaComNovoVoto = pautaRepository.save(pautaEncontrada);
        log.debug("Persistencia da pauta atualizada com o novo voto no banco de dados realizada com sucesso");
        log.trace("pautaAtualizadaComNovoVoto: {}", pautaAtualizadaComNovoVoto);

        log.debug("Iniciando acesso ao metodo responsavel por realizar a criacao de CadastroVotoResponse a partir de VotoEntity...");
        CadastroVotoResponse cadastroVotoResponse =
                mapperService.geraVotoResponseAPartirDeVotoEntity(
                        pautaAtualizadaComNovoVoto,
                        votoEntity
                );
        log.debug("Acesso ao metodo responsavel por realizar a criacao de CadastroVotoResponse a partir de VotoEntity finalizado");
        log.trace("cadastroVotoResponse: {}", cadastroVotoResponse);

        log.info("Service de cadastro de voto finalizado com sucesso");
        log.debug("Retornando objeto de resposta gerado...");
        return cadastroVotoResponse;
    }
}
