package br.com.votacao.modules.pauta.actions.obtencao.porid.models.mock;

import br.com.votacao.modules.pauta.actions.obtencao.porid.models.PautaResponse;

import java.time.LocalDateTime;

public class PautaResponseMock {

    private PautaResponse pautaResponse;

    private PautaResponseMock() {
    }

    public static PautaResponseMock builder() {

        PautaResponseMock builder = new PautaResponseMock();

        builder.pautaResponse =
                new PautaResponse(
                        "Legalização do @Data",
                        "Nessa pauta votaremos se o @Data deverá ou não ser legalizado nesta API",
                        "Encerrada",
                        1,
                        0,
                        LocalDateTime.of(2024, 11, 14, 9, 13, 0),
                        LocalDateTime.of(2024, 11, 14, 9, 13, 0),
                        VotoPautaResponseMock.builder().buildList()
                );

        return builder;
    }

    public PautaResponse build() {
        return pautaResponse;
    }
}
