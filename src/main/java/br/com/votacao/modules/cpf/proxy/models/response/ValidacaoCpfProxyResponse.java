package br.com.votacao.modules.cpf.proxy.models.response;

import br.com.votacao.modules.cpf.proxy.models.enums.StatusValidacaoCpfEnum;

public record ValidacaoCpfProxyResponse(

        StatusValidacaoCpfEnum status
) {
}
