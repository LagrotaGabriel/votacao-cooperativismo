package br.com.votacao.modules.associado.actions.cadastro.dto.response.mock;

import br.com.votacao.modules.associado.actions.cadastro.dto.response.CadastroAssociadoResponse;

import java.util.UUID;

public class CadastroAssociadoResponseMock {

    private CadastroAssociadoResponse cadastroAssociadoResponse;

    private CadastroAssociadoResponseMock() {
    }

    public static CadastroAssociadoResponseMock builder() {

        CadastroAssociadoResponseMock builder = new CadastroAssociadoResponseMock();

        builder.cadastroAssociadoResponse =
                new CadastroAssociadoResponse(
                        UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e")
                );

        return builder;
    }

    public CadastroAssociadoResponse build() {
        return cadastroAssociadoResponse;
    }
}
