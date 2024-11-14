package br.com.votacao.modules.pauta.actions.obtencao.paginada.services.core.impl;

import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.PautaPageResponse;
import br.com.votacao.modules.pauta.actions.obtencao.paginada.services.core.ObtencaoPaginadaPautaService;
import br.com.votacao.modules.pauta.actions.obtencao.paginada.services.mapper.ObtencaoPaginadaPautaMapperService;
import br.com.votacao.modules.pauta.entity.PautaEntity;
import br.com.votacao.modules.pauta.repository.PautaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * ObtencaoPaginadaPautaServiceImpl
 * Service responsável por realizar a obtenção paginada de pautas
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 22:59
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ObtencaoPaginadaPautaServiceImpl implements ObtencaoPaginadaPautaService {

    private final ObtencaoPaginadaPautaMapperService mapperService;
    private final PautaRepository pautaRepository;

    @Override
    public PautaPageResponse realizaObtencaoPaginadaPorPautas(Pageable pageable) {

        log.debug("Service responsavel por realizar a obtencao paginada por pautas acessado");
        log.trace("pageable: {}", pageable);

        log.debug("Iniciando a busca paginada por pautas...");
        Page<PautaEntity> pautaPage = pautaRepository.findAll(pageable);
        log.debug("Busca paginada por pautas realizada com sucesso");
        log.trace("pautaPage: {}", pautaPage);

        log.debug("Iniciando acesso ao mapper responsavel por realizar a conversao de Page<PautaEntity> para PautaPageResponse...");
        PautaPageResponse pautaPageResponse =
                mapperService.realizaCriacaoDeObjetoPautaPageResponse(
                        pautaPage
                );
        log.debug("Acesso ao mapper responsavel por realizar a conversao de Page<PautaEntity> para PautaPageResponse finalizado");
        log.trace("pautaPageResponse: {}", pautaPageResponse);

        log.info("Service de obtencao paginada por pautas finalizado com sucesso");
        log.debug("Retornando response gerado...");
        return pautaPageResponse;
    }
}
