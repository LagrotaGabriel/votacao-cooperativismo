package br.com.votacao.modules.voto.actions.cadastro.controller;

import br.com.votacao.exceptions.models.StandartError;
import br.com.votacao.modules.voto.actions.cadastro.dto.request.CadastroVotoRequest;
import br.com.votacao.modules.voto.actions.cadastro.dto.response.CadastroVotoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public interface CadastroVotoSwaggerController {

    @Tag(name = "Cadastro de novo voto")
    @Operation(summary = "Esse endpoint tem como objetivo realizar o cadastro de um novo voto",
            method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Voto computado com sucesso",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CadastroVotoResponse.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Um associado não pode votar mais de uma vez em uma pauta",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = StandartError.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Não é possível realizar a votação em uma pauta que já expirou",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = StandartError.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Nenhuma pauta foi encontrada com o id informado",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = StandartError.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Nenhum associado foi encontrado com o id informado",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = StandartError.class))}),
    })
    ResponseEntity<CadastroVotoResponse> criaNovoVoto(
            @PathVariable("idPauta") UUID idPauta,
            @Valid @RequestBody CadastroVotoRequest cadastroVotoRequest
    );
}
