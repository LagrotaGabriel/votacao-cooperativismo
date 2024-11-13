package br.com.votacao.modules.associado.actions.cadastro.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CadastroAssociadoRequest(

        @JsonProperty("nome")
        @NotEmpty(message = "O nome do associado deverá ser informado")
        @Parameter(name = "Nome do associado", example = "Gabriel Lagrota", required = true)
        @Size(max = 60, message = "O nome do associado deve conter no máximo {max} caracteres")
        String nome,

        @JsonProperty("cpf")
        @NotEmpty(message = "O CPF do associado deverá ser informado")
        @Parameter(name = "CPF do associado", example = "472.545.279-22", required = true)
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF informado é inválido. Use um padrão válido. Exemplo: 111.111.111-11")
        String cpf
) {}
