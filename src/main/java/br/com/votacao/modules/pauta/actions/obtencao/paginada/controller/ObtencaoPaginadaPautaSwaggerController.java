package br.com.votacao.modules.pauta.actions.obtencao.paginada.controller;

import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.PautaPageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

public interface ObtencaoPaginadaPautaSwaggerController {

    @Tag(name = "Obtenção paginada por pautas")
    @Operation(summary = "Esse endpoint tem como objetivo realizar a obtenção paginada por pautas", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Pautas obtidas com sucesso",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PautaPageResponse.class))})
    })
    ResponseEntity<PautaPageResponse> realizaObtencaoPaginadaPorPautas(
            @PageableDefault Pageable pageable
    );
}
