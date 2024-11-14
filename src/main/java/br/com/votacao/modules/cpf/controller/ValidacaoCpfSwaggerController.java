package br.com.votacao.modules.cpf.controller;

import br.com.votacao.modules.cpf.models.request.CpfRequest;
import br.com.votacao.modules.cpf.models.response.CpfResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ValidacaoCpfSwaggerController {

    @Tag(name = "Validação de CPF")
    @Operation(summary = "Esse endpoint tem como objetivo realizar a validação se um CPF pode ou não votar",
            method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "CPF apto para votar",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CpfResponse.class))}),
            @ApiResponse(responseCode = "404",
                    description = "CPF não apto para votar",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CpfResponse.class))})
    })
    ResponseEntity<CpfResponse> validaCpf(
            @Valid @RequestBody CpfRequest cpfRequest
    );
}
