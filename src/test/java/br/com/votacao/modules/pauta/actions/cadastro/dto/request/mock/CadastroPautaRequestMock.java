package br.com.votacao.modules.pauta.actions.cadastro.dto.request.mock;


import br.com.votacao.modules.pauta.actions.cadastro.dto.request.CadastroPautaRequest;

public class CadastroPautaRequestMock {

    private CadastroPautaRequest cadastroPautaRequest;

    private CadastroPautaRequestMock() {
    }

    public static CadastroPautaRequestMock builder() {

        CadastroPautaRequestMock builder = new CadastroPautaRequestMock();

        builder.cadastroPautaRequest =
                new CadastroPautaRequest(
                        "Legalização do @Data",
                        "Nessa pauta votaremos se o @Data deverá ou não ser legalizado nesta API",
                        5
                );

        return builder;
    }

    public CadastroPautaRequestMock semMinutosInformados() {

        this.cadastroPautaRequest =
                new CadastroPautaRequest(
                        "Legalização do @Data",
                        "Nessa pauta votaremos se o @Data deverá ou não ser legalizado nesta API",
                        null
                );

        return this;
    }

    public CadastroPautaRequest build() {
        return cadastroPautaRequest;
    }
}
