package br.com.votacao.modules.pauta.actions.obtencao.porid.controller;

import br.com.votacao.exceptions.models.StandartError;
import br.com.votacao.modules.pauta.actions.obtencao.porid.models.PautaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

public interface ObtencaoPautaPorIdSwaggerController {

    @Tag(name = "Obtenção de pauta por id")
    @Operation(summary = "Esse endpoint tem como objetivo realizar a obtenção de pauta por id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Pauta obtida com sucesso",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PautaResponse.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Nenhuma pauta foi encontrada com o ID informado",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = StandartError.class))})
    })
    ResponseEntity<PautaResponse> realizaObtencaoDePautaPorId(
            @PathVariable("id") UUID id
    );
}
