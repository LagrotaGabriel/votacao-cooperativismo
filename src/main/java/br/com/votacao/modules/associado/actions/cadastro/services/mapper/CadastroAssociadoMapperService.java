package br.com.votacao.modules.associado.actions.cadastro.services.mapper;

import br.com.votacao.modules.associado.actions.cadastro.dto.request.CadastroAssociadoRequest;
import br.com.votacao.modules.associado.actions.cadastro.dto.response.CadastroAssociadoResponse;
import br.com.votacao.modules.associado.entity.AssociadoEntity;

public interface CadastroAssociadoMapperService {

    AssociadoEntity geraAssociadoEntityAPartirDeCadastroAssociadoRequest(
            CadastroAssociadoRequest cadastroAssociadoRequest
    );

    CadastroAssociadoResponse geraAssociadoResponseAPartirDeAssociadoEntity(
            AssociadoEntity associadoEntity
    );
}
