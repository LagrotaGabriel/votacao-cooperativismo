package br.com.votacao.modules.pauta.actions.obtencao.porid.services.mapper;

import br.com.votacao.modules.pauta.actions.obtencao.porid.models.PautaResponse;
import br.com.votacao.modules.pauta.actions.obtencao.porid.models.VotoPautaResponse;
import br.com.votacao.modules.pauta.models.entity.PautaEntity;
import br.com.votacao.modules.voto.entity.VotoEntity;

import java.util.List;

public interface ObtencaoPautaPorIdMapperService {

    PautaResponse realizaCriacaoDeObjetoPautaResponse(
            PautaEntity pautaEntity
    );

    List<VotoPautaResponse> geraListaDeVotos(
            List<VotoEntity> votos
    );
}
