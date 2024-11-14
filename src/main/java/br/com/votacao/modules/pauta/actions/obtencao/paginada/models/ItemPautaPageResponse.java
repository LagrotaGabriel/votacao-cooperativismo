package br.com.votacao.modules.pauta.actions.obtencao.paginada.models;

import java.time.LocalDateTime;
import java.util.UUID;

public record ItemPautaPageResponse(

        UUID id,
        String titulo,
        String descricao,
        String status,
        Integer quantidadeDeVotos,
        Integer quantidadeVotosSim,
        Integer quantidadesVotosNao,
        LocalDateTime dataHoraCriacao,
        LocalDateTime dataHoraExpiracao
) {
}
