package br.com.votacao.modules.voto.actions.cadastro.dto.response;

import io.swagger.v3.oas.annotations.Parameter;

import java.util.UUID;

public record CadastroVotoResponse(

        @Parameter(name = "Id do voto", example = "74bcd515-655c-4def-8dc8-3329ccbdf62e")
        UUID idVoto,

        @Parameter(name = "Quantidade de votos computados na pauta", example = "343")
        Integer quantidadeDeVotosComputados
) {
}
