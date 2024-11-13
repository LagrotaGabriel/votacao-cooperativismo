package br.com.votacao.modules.voto.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoVotoEnum {

    SIM(0, "Sim"),
    NAO(1, "Não");

    private final int code;
    private final String desc;
}
