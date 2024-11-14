package br.com.votacao.modules.pauta.actions.obtencao.paginada.models.mock;

import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.VotosPautaPageResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VotosPautaPageResponseMock {

    private VotosPautaPageResponse votosPautaPageResponse;

    private VotosPautaPageResponseMock() {
    }

    public static VotosPautaPageResponseMock builder() {

        VotosPautaPageResponseMock builder = new VotosPautaPageResponseMock();

        builder.votosPautaPageResponse =
                new VotosPautaPageResponse(
                        "Sim",
                        LocalDateTime.of(2024, 11, 13, 23, 53, 0),
                        "Gabriel Lagrota"
                );

        return builder;
    }

    public List<VotosPautaPageResponse> buildList() {

        List<VotosPautaPageResponse> votosPautaPageResponseList = new ArrayList<>();
        votosPautaPageResponseList.add(this.votosPautaPageResponse);

        return votosPautaPageResponseList;
    }

    public VotosPautaPageResponse build() {
        return votosPautaPageResponse;
    }
}
