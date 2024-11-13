package br.com.votacao.modules.associado.actions.cadastro.dto.response;

import io.swagger.v3.oas.annotations.Parameter;

import java.util.UUID;

public record CadastroAssociadoResponse(

        @Parameter(name = "Id do associado", example = "74bcd515-655c-4def-8dc8-3329ccbdf62e")
        UUID id

) { }
