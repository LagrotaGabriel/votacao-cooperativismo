package br.com.votacao.modules.cpf.models.response.mock;

import br.com.votacao.modules.cpf.models.response.CpfResponse;
import br.com.votacao.modules.cpf.proxy.models.enums.StatusValidacaoCpfEnum;

import java.time.LocalDateTime;

public class CpfResponseMock {

    private CpfResponse cpfResponse;

    private CpfResponseMock() {
    }

    public static CpfResponseMock builder() {

        CpfResponseMock builder = new CpfResponseMock();

        builder.cpfResponse =
                new CpfResponse(
                        StatusValidacaoCpfEnum.ABLE_TO_VOTE,
                        LocalDateTime.of(2024, 11, 14, 11, 57)
                );

        return builder;
    }

    public CpfResponse build() {
        return cpfResponse;
    }
}
