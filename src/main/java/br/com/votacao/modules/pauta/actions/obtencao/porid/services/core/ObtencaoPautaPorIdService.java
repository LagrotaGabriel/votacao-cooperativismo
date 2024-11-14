package br.com.votacao.modules.pauta.actions.obtencao.porid.services.core;

import br.com.votacao.modules.pauta.actions.obtencao.porid.models.PautaResponse;

import java.util.UUID;

public interface ObtencaoPautaPorIdService {

    PautaResponse realizaObtencaoDePautaPorId(
            UUID idPauta
    );
}
