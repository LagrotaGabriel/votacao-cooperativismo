package br.com.votacao.modules.voto.actions.cadastro.services.core;

import br.com.votacao.modules.voto.actions.cadastro.dto.request.CadastroVotoRequest;
import br.com.votacao.modules.voto.actions.cadastro.dto.response.CadastroVotoResponse;

import java.util.UUID;

public interface CadastroVotoService {

    CadastroVotoResponse realizaCadastroDeNovoVoto(
            UUID idPauta,
            CadastroVotoRequest cadastroVotoRequest
    );
}
