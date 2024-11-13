package br.com.votacao.modules.pauta.actions.cadastro.controller;

import br.com.votacao.modules.pauta.actions.cadastro.dto.request.CadastroPautaRequest;
import br.com.votacao.modules.pauta.actions.cadastro.dto.response.CadastroPautaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface CadastroPautaSwaggerController {

    @Tag(name = "Cadastro de nova pauta")
    @Operation(summary = "Esse endpoint tem como objetivo realizar o cadastro de uma nova pauta",
            method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Pauta criada com sucesso",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CadastroPautaResponse.class))})
    })
    ResponseEntity<CadastroPautaResponse> criaNovaPauta(
            @Valid @RequestBody CadastroPautaRequest cadastroPautaRequest
    );
}
