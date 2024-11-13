package br.com.votacao.modules.pauta.actions.cadastro.services.core;

import br.com.votacao.modules.pauta.actions.cadastro.dto.request.CadastroPautaRequest;
import br.com.votacao.modules.pauta.actions.cadastro.dto.response.CadastroPautaResponse;

public interface CadastroPautaService {

    CadastroPautaResponse realizaCadastroDeNovaPauta(
            CadastroPautaRequest cadastroPautaRequest
    );
}
