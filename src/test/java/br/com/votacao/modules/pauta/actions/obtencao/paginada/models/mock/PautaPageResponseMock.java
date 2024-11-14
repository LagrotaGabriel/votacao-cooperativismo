package br.com.votacao.modules.pauta.actions.obtencao.paginada.models.mock;

import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.PautaPageResponse;

public class PautaPageResponseMock {

    private PautaPageResponse pautaPageResponse;

    private PautaPageResponseMock() {
    }

    public static PautaPageResponseMock builder() {

        PautaPageResponseMock builder = new PautaPageResponseMock();

        builder.pautaPageResponse =
                new PautaPageResponse(
                        ItemPautaPageResponseMock.builder().buildList(),
                        7,
                        0,
                        10,
                        10,
                        7L,
                        1
                );

        return builder;
    }

    public PautaPageResponse build() {
        return pautaPageResponse;
    }
}
