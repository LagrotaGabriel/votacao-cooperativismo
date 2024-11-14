package br.com.votacao.modules.pauta.actions.obtencao.porid.models.mock;

import br.com.votacao.modules.pauta.actions.obtencao.porid.models.VotoPautaResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VotoPautaResponseMock {

    private VotoPautaResponse votoPautaResponse;

    private VotoPautaResponseMock() {
    }

    public static VotoPautaResponseMock builder() {

        VotoPautaResponseMock builder = new VotoPautaResponseMock();

        builder.votoPautaResponse =
                new VotoPautaResponse(
                        "Sim",
                        LocalDateTime.of(2024, 11, 13, 23, 53, 0),
                        "Gabriel Lagrota"
                );

        return builder;
    }

    public List<VotoPautaResponse> buildList() {

        List<VotoPautaResponse> votoPautaResponseList = new ArrayList<>();
        votoPautaResponseList.add(this.votoPautaResponse);

        return votoPautaResponseList;
    }

    public VotoPautaResponse build() {
        return votoPautaResponse;
    }
}
