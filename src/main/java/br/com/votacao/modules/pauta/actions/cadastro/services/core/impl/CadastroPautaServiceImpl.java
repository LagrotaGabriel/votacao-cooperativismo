package br.com.votacao.modules.pauta.actions.cadastro.services.core.impl;

import br.com.votacao.modules.pauta.actions.cadastro.dto.request.CadastroPautaRequest;
import br.com.votacao.modules.pauta.actions.cadastro.dto.response.CadastroPautaResponse;
import br.com.votacao.modules.pauta.actions.cadastro.services.core.CadastroPautaService;
import br.com.votacao.modules.pauta.actions.cadastro.services.mapper.CadastroPautaMapperService;
import br.com.votacao.modules.pauta.entity.PautaEntity;
import br.com.votacao.modules.pauta.repository.PautaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * CadastroPautaServiceImpl
 * Service responsável por realizar o cadastro de uma nova pauta
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 11:13
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CadastroPautaServiceImpl implements CadastroPautaService {

    private final CadastroPautaMapperService mapperService;
    private final PautaRepository repository;

    @Override
    public CadastroPautaResponse realizaCadastroDeNovaPauta(CadastroPautaRequest cadastroPautaRequest) {

        log.debug("Metodo responsavel por realizar o cadastro de uma nova pauta acessado");
        log.trace("cadastroPautaRequest: {}", cadastroPautaRequest);

        log.debug("Iniciando acesso ao metodo responsavel por realizar a criacao de PautaEntity a partir de CadastroPautaRequest...");
        PautaEntity pautaEntity =
                mapperService.geraPautaEntityAPartirDeCadastroPautaRequest(
                        cadastroPautaRequest
                );
        log.debug("Acesso ao metodo responsavel por realizar a criacao de PautaEntity a partir de CadastroPautaRequest finalizado");
        log.trace("pautaEntity: {}", pautaEntity);

        log.debug("Iniciando persistencia da pauta gerada no banco de dados...");
        PautaEntity pautaPersistida = repository.save(pautaEntity);
        log.debug("Persistencia da pauta gerada no banco de dados realizada com sucesso");
        log.trace("pautaPersistida: {}", pautaPersistida);

        log.debug("Iniciando acesso ao metodo responsavel por realizar a criacao de CadastroPautaResponse a partir de PautaEntity...");
        CadastroPautaResponse cadastroPautaResponse =
                mapperService.geraPautaResponseAPartirDePautaEntity(
                        pautaPersistida
                );
        log.debug("Acesso ao metodo responsavel por realizar a criacao de CadastroPautaResponse a partir de PautaEntity finalizado");
        log.trace("cadastroPautaResponse: {}", cadastroPautaResponse);

        log.info("Service de cadastro de nova pauta finalizado com sucesso");
        log.debug("Retornando objeto de resposta gerado...");
        return cadastroPautaResponse;
    }
}
