package br.com.votacao.modules.pauta.actions.cadastro.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.*;

public record CadastroPautaRequest(

        @JsonProperty("titulo")
        @NotEmpty(message = "O título da pauta deverá ser informado")
        @Parameter(name = "Título da pauta", example = "Legalização do @Data", required = true)
        @Size(max = 60, message = "O título da pauta deverá conter no máximo {max} caracteres")
        String titulo,

        @JsonProperty("descricao")
        @NotEmpty(message = "A descrição da pauta deverá ser informada")
        @Parameter(name = "Descrição da pauta", example = "Nessa pauta votaremos se o @Data deverá ou não ser legalizado nesta API", required = true)
        @Size(max = 80, message = "A descrição da pauta deverá conter no máximo {max} caracteres")
        String descricao,

        @JsonProperty("duracaoEmMinutos")
        @Parameter(name = "Duração da pauta em minutos", example = "5")
        @Min(message = "A duração da pauta em minutos não pode ser menor do que {value}", value = 1)
        @Max(message = "A duração da pauta em minutos não pode ser maior do que {value}", value = 999)
        Integer duracaoEmMinutos

) { }
