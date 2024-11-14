package br.com.votacao.modules.cpf.proxy.models.response.mock;

import br.com.votacao.modules.cpf.proxy.models.enums.StatusValidacaoCpfEnum;
import br.com.votacao.modules.cpf.proxy.models.response.ValidacaoCpfProxyResponse;

public class ValidacaoCpfProxyResponseMock {

    private ValidacaoCpfProxyResponse validacaoCpfProxyResponse;

    private ValidacaoCpfProxyResponseMock() {
    }

    public static ValidacaoCpfProxyResponseMock builder() {

        ValidacaoCpfProxyResponseMock builder = new ValidacaoCpfProxyResponseMock();

        builder.validacaoCpfProxyResponse =
                new ValidacaoCpfProxyResponse(
                        StatusValidacaoCpfEnum.ABLE_TO_VOTE
                );

        return builder;
    }

    public ValidacaoCpfProxyResponse build() {
        return validacaoCpfProxyResponse;
    }
}
