package br.com.votacao.modules.pauta.actions.cadastro.dto.response;

import io.swagger.v3.oas.annotations.Parameter;

import java.time.LocalDateTime;
import java.util.UUID;

public record CadastroPautaResponse(

        @Parameter(name = "Id da pauta", example = "74bcd515-655c-4def-8dc8-3329ccbdf62e")
        UUID id,

        @Parameter(name = "Título da pauta", example = "Legalização do @Data")
        String titulo,

        @Parameter(name = "Descrição da pauta", example = "Nessa pauta votaremos se o @Data deverá ou não ser legalizado nesta API")
        String descricao,

        @Parameter(name = "Data e hora de expiraçao da pauta", example = "2024-11-13T10:41:42.713138")
        LocalDateTime dataHoraexpiracaoPauta
) {
}
