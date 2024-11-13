package br.com.votacao.modules.associado.actions.cadastro.services.core;

import br.com.votacao.modules.associado.actions.cadastro.dto.request.CadastroAssociadoRequest;
import br.com.votacao.modules.associado.actions.cadastro.dto.response.CadastroAssociadoResponse;

public interface CadastroAssociadoService {

    CadastroAssociadoResponse realizaCadastroDeNovoAssociado(
            CadastroAssociadoRequest cadastroAssociadoRequest
    );
}
