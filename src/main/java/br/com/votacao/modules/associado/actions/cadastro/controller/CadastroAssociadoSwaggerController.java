package br.com.votacao.modules.associado.actions.cadastro.controller;

import br.com.votacao.exceptions.models.StandartError;
import br.com.votacao.modules.associado.actions.cadastro.dto.request.CadastroAssociadoRequest;
import br.com.votacao.modules.associado.actions.cadastro.dto.response.CadastroAssociadoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface CadastroAssociadoSwaggerController {

    @Tag(name = "Cadastro de novo associado")
    @Operation(summary = "Esse endpoint tem como objetivo realizar o cadastro de um novo associado",
            method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Associado criado com sucesso",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CadastroAssociadoResponse.class))}),
            @ApiResponse(responseCode = "400",
                    description = "CPF já existe",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = StandartError.class))}),
    })
    ResponseEntity<CadastroAssociadoResponse> criaNovoAssociado(
            @Valid @RequestBody CadastroAssociadoRequest criaAssociadoRequest
    );
}
