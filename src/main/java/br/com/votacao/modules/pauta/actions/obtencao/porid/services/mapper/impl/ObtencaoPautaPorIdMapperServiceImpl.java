package br.com.votacao.modules.pauta.actions.obtencao.porid.services.mapper.impl;

import br.com.votacao.modules.pauta.actions.obtencao.porid.models.PautaResponse;
import br.com.votacao.modules.pauta.actions.obtencao.porid.models.VotoPautaResponse;
import br.com.votacao.modules.pauta.actions.obtencao.porid.services.mapper.ObtencaoPautaPorIdMapperService;
import br.com.votacao.modules.pauta.models.entity.PautaEntity;
import br.com.votacao.modules.pauta.models.enums.StatusPautaEnum;
import br.com.votacao.modules.voto.entity.VotoEntity;
import br.com.votacao.modules.voto.entity.enums.TipoVotoEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * ObtencaoPautaPorIdMapperServiceImpl
 * Classe responsável por realizar o mapeamento e construção de objetos considerando o contexto da obtenção de pautas
 * por id
 * <p>
 * Observação: Tenho preferência por utilizar MapperServices gerados por mim ao invés de ModelMapper, pois acredito que
 * eles proporcionem maior flexibilidade com relação a construção dos objetos.
 * <p>
 * Além do mais, ModelMapper podem ser prejudiciais para a performance da aplicação a longo prazo, pois em
 * alguns casos de relacionamentos entre entidades, podem causar gaps de memória. Derrubando a aplicação temporariamente.
 *
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 14/11/2024 - 08:22
 */
@Slf4j
@Service
public class ObtencaoPautaPorIdMapperServiceImpl implements ObtencaoPautaPorIdMapperService {


    @Override
    public PautaResponse realizaCriacaoDeObjetoPautaResponse(PautaEntity pautaEntity) {

        log.debug("Mapper responsavel por realizar a criacao de objeto PautaPageResponse acessado");
        log.trace("pautaEntity: {}", pautaEntity);

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

        log.debug("Iniciando construcao de objeto PautaPageResponse...");
        PautaResponse pautaResponse =
                new PautaResponse(
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
        log.debug("Construcao de objeto PautaPageResponse realizado");
        log.trace("pautaResponse: {}", pautaResponse);

        log.debug("Retornando objeto pautaResponse gerado...");
        return pautaResponse;
    }

    @Override
    public List<VotoPautaResponse> geraListaDeVotos(List<VotoEntity> votos) {

        List<VotoPautaResponse> votosPautaPageResponseList = new ArrayList<>();

        for (VotoEntity votoEntity : votos) {
            VotoPautaResponse votosPautaPageResponse =
                    new VotoPautaResponse(
                            votoEntity.getTipoVoto().getDesc(),
                            votoEntity.getDataHoraVoto(),
                            votoEntity.getAssociado().getNome()
                    );

            votosPautaPageResponseList.add(votosPautaPageResponse);
        }

        return votosPautaPageResponseList;
    }
}
