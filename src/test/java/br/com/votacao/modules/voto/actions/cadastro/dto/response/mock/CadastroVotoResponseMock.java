package br.com.votacao.modules.voto.actions.cadastro.dto.response.mock;

import br.com.votacao.modules.voto.actions.cadastro.dto.response.CadastroVotoResponse;

import java.util.UUID;

public class CadastroVotoResponseMock {

    private CadastroVotoResponse cadastroVotoResponse;

    private CadastroVotoResponseMock() {
    }

    public static CadastroVotoResponseMock builder() {

        CadastroVotoResponseMock builder = new CadastroVotoResponseMock();

        builder.cadastroVotoResponse =
                new CadastroVotoResponse(
                        UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e"),
                        5
                );

        return builder;
    }

    public CadastroVotoResponse build() {
        return cadastroVotoResponse;
    }
}
