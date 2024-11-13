package br.com.votacao.exceptions.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class StandartError {

    private String localDateTime;
    private Integer status;
    private String error;
    private String path;
}
