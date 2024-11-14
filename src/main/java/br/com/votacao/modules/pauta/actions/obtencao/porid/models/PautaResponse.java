package br.com.votacao.modules.pauta.actions.obtencao.porid.models;

import java.time.LocalDateTime;
import java.util.List;

public record PautaResponse(

        String titulo,
        String descricao,
        String status,
        Integer quantidadeVotosSim,
        Integer quantidadesVotosNao,
        LocalDateTime dataHoraCriacao,
        LocalDateTime dataHoraExpiracao,
        List<VotoPautaResponse> votos
) {
}
