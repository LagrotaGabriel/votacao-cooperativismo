package br.com.votacao.modules.associado.actions.cadastro.dto.request.mock;

import br.com.votacao.modules.associado.actions.cadastro.dto.request.CadastroAssociadoRequest;

public class CadastroAssociadoRequestMock {

    private CadastroAssociadoRequest cadastroAssociadoRequest;

    private CadastroAssociadoRequestMock() {
    }

    public static CadastroAssociadoRequestMock builder() {

        CadastroAssociadoRequestMock builder = new CadastroAssociadoRequestMock();

        builder.cadastroAssociadoRequest =
                new CadastroAssociadoRequest(
                        "Gabriel",
                        "472.535.279-22"
                );

        return builder;
    }

    public CadastroAssociadoRequest build() {
        return cadastroAssociadoRequest;
    }
}
