package br.com.votacao.modules.pauta.actions.obtencao.paginada.services.core;

import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.PautaPageResponse;
import org.springframework.data.domain.Pageable;

public interface ObtencaoPaginadaPautaService {

    PautaPageResponse realizaObtencaoPaginadaPorPautas(
            Pageable pageable
    );
}
