package br.com.votacao.modules.pauta.actions.obtencao.paginada.services.mapper.impl;

import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.ItemPautaPageResponse;
import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.PautaPageResponse;
import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.VotosPautaPageResponse;
import br.com.votacao.modules.pauta.models.enums.StatusPautaEnum;
import br.com.votacao.modules.pauta.actions.obtencao.paginada.services.mapper.ObtencaoPaginadaPautaMapperService;
import br.com.votacao.modules.pauta.models.entity.PautaEntity;
import br.com.votacao.modules.voto.entity.VotoEntity;
import br.com.votacao.modules.voto.entity.enums.TipoVotoEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * ObtencaoPaginadaPautaMapperServiceImpl
 * Classe responsável por realizar o mapeamento e construção de objetos considerando o contexto da obtenção paginada
 * de pautas
 * <p>
 * Observação: Tenho preferência por utilizar MapperServices gerados por mim ao invés de ModelMapper, pois acredito que
 * eles proporcionem maior flexibilidade com relação a construção dos objetos.
 * <p>
 * Além do mais, ModelMapper podem ser prejudiciais para a performance da aplicação a longo prazo, pois em
 * alguns casos de relacionamentos entre entidades, podem causar gaps de memória. Derrubando a aplicação temporariamente.
 *
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 23:01
 */
@Slf4j
@Service
public class ObtencaoPaginadaPautaMapperServiceImpl implements ObtencaoPaginadaPautaMapperService {

    @Override
    public PautaPageResponse realizaCriacaoDeObjetoPautaPageResponse(Page<PautaEntity> pautaPage) {

        log.debug("Mapper responsavel por realizar a criacao de objeto PautaPageResponse acessado");
        log.trace("pautaPage: {}", pautaPage);

        log.debug("Iniciando construcao de objeto PautaPageResponse...");
        PautaPageResponse pautaPageResponse =
                new PautaPageResponse(
                        geraListaDeItemPautaPageResponse(pautaPage.getContent()),
                        pautaPage.getNumberOfElements(),
                        pautaPage.getPageable().getPageNumber(),
                        pautaPage.getPageable().getPageSize(),
                        pautaPage.getSize(),
                        pautaPage.getTotalElements(),
                        pautaPage.getTotalPages()
                );
        log.debug("Construcao de objeto PautaPageResponse realizado");
        log.trace("pautaPageResponse: {}", pautaPageResponse);

        log.debug("Retornando objeto pautaPageResponse gerado...");
        return pautaPageResponse;
    }

    @Override
    public List<ItemPautaPageResponse> geraListaDeItemPautaPageResponse(List<PautaEntity> content) {

        List<ItemPautaPageResponse> itemPautaPageResponseList = new ArrayList<>();

        for (PautaEntity pautaEntity : content) {

            Integer quantidadeVotosSim =
                    Math.toIntExact(
                            pautaEntity.getVotos().stream()
                                    .filter(votoEntity -> TipoVotoEnum.SIM.equals(votoEntity.getTipoVoto()))
                                    .count()
                    );

            Integer quantidadeVotosNao =
                    Math.toIntExact(
                            pautaEntity.getVotos().stream()
                                    .filter(votoEntity -> TipoVotoEnum.NAO.equals(votoEntity.getTipoVoto()))
                                    .count()
                    );

            ItemPautaPageResponse itemPautaPageResponse =
                    new ItemPautaPageResponse(
                            pautaEntity.getTitulo(),
                            pautaEntity.getDescricao(),
                            (pautaEntity.getDataHoraExpiracao().isBefore(LocalDateTime.now()))
                                    ? StatusPautaEnum.ENCERRADA.getDesc()
                                    : StatusPautaEnum.EM_ABERTO.getDesc(),
                            quantidadeVotosSim,
                            quantidadeVotosNao,
                            pautaEntity.getDataHoraCriacao(),
                            pautaEntity.getDataHoraExpiracao(),
                            geraListaDeVotos(pautaEntity.getVotos())
                    );

            itemPautaPageResponseList.add(itemPautaPageResponse);
        }

        return itemPautaPageResponseList;
    }

    public List<VotosPautaPageResponse> geraListaDeVotos(List<VotoEntity> votos) {

        List<VotosPautaPageResponse> votosPautaPageResponseList = new ArrayList<>();

        for (VotoEntity votoEntity : votos) {
            VotosPautaPageResponse votosPautaPageResponse =
                    new VotosPautaPageResponse(
                            votoEntity.getTipoVoto().getDesc(),
                            votoEntity.getDataHoraVoto(),
                            votoEntity.getAssociado().getNome()
                    );

            votosPautaPageResponseList.add(votosPautaPageResponse);
        }

        return votosPautaPageResponseList;
    }
}
