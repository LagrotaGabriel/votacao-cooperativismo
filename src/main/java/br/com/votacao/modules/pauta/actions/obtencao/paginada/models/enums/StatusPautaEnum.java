package br.com.votacao.modules.pauta.actions.obtencao.paginada.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusPautaEnum {

    EM_ABERTO (0, "Em aberto"),
    ENCERRADA (1, "Encerrada");

    private final int code;
    private final String desc;
}
