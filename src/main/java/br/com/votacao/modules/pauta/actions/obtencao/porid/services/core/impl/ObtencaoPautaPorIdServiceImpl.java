package br.com.votacao.modules.pauta.actions.obtencao.porid.services.core.impl;

import br.com.votacao.modules.pauta.actions.obtencao.porid.models.PautaResponse;
import br.com.votacao.modules.pauta.actions.obtencao.porid.services.core.ObtencaoPautaPorIdService;
import br.com.votacao.modules.pauta.actions.obtencao.porid.services.core.exceptions.PautaNaoEncontradaPorIdException;
import br.com.votacao.modules.pauta.actions.obtencao.porid.services.mapper.ObtencaoPautaPorIdMapperService;
import br.com.votacao.modules.pauta.models.entity.PautaEntity;
import br.com.votacao.modules.pauta.repository.PautaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * ObtencaoPautaPorIdServiceImpl
 * Service responsável por implementar lógica de obtenção de pauta por ID
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 14/11/2024 - 08:18
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ObtencaoPautaPorIdServiceImpl implements ObtencaoPautaPorIdService {

    private final ObtencaoPautaPorIdMapperService mapperService;
    private final PautaRepository pautaRepository;

    @Override
    public PautaResponse realizaObtencaoDePautaPorId(UUID idPauta) {

        log.debug("Service responsavel por realizar a obtencao de pauta por id acessado");
        log.trace("idPauta: {}", idPauta);

        log.debug("Iniciando a busca de pauta por id...");
        PautaEntity pautaEntity =
                pautaRepository.findById(idPauta).orElseThrow(() -> {
                            log.warn("Nenhuma pauta foi encontrada atraves do ID informado: {}", idPauta);
                            return new PautaNaoEncontradaPorIdException("Nenhuma pauta foi encontrada através do ID informado");
                        }
                );
        log.debug("Busca de pauta por id realizada com sucesso");
        log.trace("pautaEntity: {}", pautaEntity);

        log.debug("Iniciando acesso ao mapper responsavel por realizar a conversao de PautaEntity para PautaResponse...");
        PautaResponse pautaResponse =
                mapperService.realizaCriacaoDeObjetoPautaResponse(
                        pautaEntity
                );
        log.debug("Acesso ao mapper responsavel por realizar a conversao de PautaEntity para PautaResponse finalizado");
        log.trace("pautaResponse: {}", pautaResponse);

        log.info("Service de obtencao de pauta por id finalizado com sucesso");
        log.debug("Retornando response gerado...");
        return pautaResponse;
    }
}
