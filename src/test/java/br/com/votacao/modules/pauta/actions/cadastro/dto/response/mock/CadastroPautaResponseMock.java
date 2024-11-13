package br.com.votacao.modules.pauta.actions.cadastro.dto.response.mock;

import br.com.votacao.modules.pauta.actions.cadastro.dto.response.CadastroPautaResponse;

import java.time.LocalDateTime;
import java.util.UUID;

public class CadastroPautaResponseMock {

    private CadastroPautaResponse cadastroPautaResponse;

    private CadastroPautaResponseMock() {
    }

    public static CadastroPautaResponseMock builder() {

        CadastroPautaResponseMock builder = new CadastroPautaResponseMock();

        builder.cadastroPautaResponse =
                new CadastroPautaResponse(
                        UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e"),
                        "Legalização do @Data",
                        "Nessa pauta votaremos se o @Data deverá ou não ser legalizado nesta API",
                        LocalDateTime.of(2024, 11, 13, 15, 37, 0)
                );

        return builder;
    }

    public CadastroPautaResponse build() {
        return cadastroPautaResponse;
    }
}
