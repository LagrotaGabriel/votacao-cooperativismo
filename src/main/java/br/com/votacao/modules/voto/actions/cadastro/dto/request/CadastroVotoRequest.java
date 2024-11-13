package br.com.votacao.modules.voto.actions.cadastro.dto.request;

import br.com.votacao.modules.voto.entity.enums.TipoVotoEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CadastroVotoRequest(

        @JsonProperty("voto")
        @NotNull(message = "O voto do associado deverá ser informado")
        @Parameter(name = "Voto do associado", example = "SIM")
        TipoVotoEnum voto,

        @JsonProperty("idAssociado")
        @NotNull(message = "O id do associado que irá registrar o voto deverá ser informado")
        @Parameter(name = "ID do associado que irá votar", example = "74bcd515-655c-4def-8dc8-3329ccbdf62e")
        UUID idAssociado
) { }
