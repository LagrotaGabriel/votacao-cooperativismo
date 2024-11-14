package br.com.votacao.modules.cpf.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record CpfRequest(

        @JsonProperty("cpf")
        @NotEmpty(message = "O CPF deverá ser informado")
        @Parameter(name = "CPF", example = "472.534.288-22", required = true)
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF informado é inválido")
        String cpf
) { }