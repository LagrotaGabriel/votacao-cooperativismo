package br.com.votacao.modules.cpf.models.request.mock;

import br.com.votacao.modules.cpf.models.request.CpfRequest;

public class CpfRequestMock {

    private CpfRequest cpfRequest;

    private CpfRequestMock() {
    }

    public static CpfRequestMock builder() {

        CpfRequestMock builder = new CpfRequestMock();

        builder.cpfRequest =
                new CpfRequest(
                        "111.111.111-11"
                );

        return builder;
    }

    public CpfRequest build() {
        return cpfRequest;
    }
}
