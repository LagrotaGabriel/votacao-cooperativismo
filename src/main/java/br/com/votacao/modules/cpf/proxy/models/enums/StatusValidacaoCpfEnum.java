package br.com.votacao.modules.cpf.proxy.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusValidacaoCpfEnum {

    ABLE_TO_VOTE(0, "CPF liberado para votar"),
    UNABLE_TO_VOTE(1, "CPF não liberado para votar");

    private final int code;
    private final String desc;
}
