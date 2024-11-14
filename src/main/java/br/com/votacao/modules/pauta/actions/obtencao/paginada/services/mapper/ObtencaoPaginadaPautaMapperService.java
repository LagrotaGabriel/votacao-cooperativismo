package br.com.votacao.modules.pauta.actions.obtencao.paginada.services.mapper;

import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.ItemPautaPageResponse;
import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.PautaPageResponse;
import br.com.votacao.modules.pauta.entity.PautaEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ObtencaoPaginadaPautaMapperService {

    PautaPageResponse realizaCriacaoDeObjetoPautaPageResponse(
            Page<PautaEntity> pautaPage
    );

    List<ItemPautaPageResponse> geraListaDeItemPautaPageResponse(
            List<PautaEntity> content
    );
}
