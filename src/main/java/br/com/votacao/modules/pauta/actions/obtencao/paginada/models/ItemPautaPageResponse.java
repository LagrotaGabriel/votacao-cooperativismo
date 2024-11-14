package br.com.votacao.modules.pauta.actions.obtencao.paginada.models;

import java.time.LocalDateTime;
import java.util.List;

public record ItemPautaPageResponse(

        String titulo,
        String descricao,
        String status,
        Integer quantidadeVotosSim,
        Integer quantidadesVotosNao,
        LocalDateTime dataHoraCriacao,
        LocalDateTime dataHoraExpiracao,
        List<VotosPautaPageResponse> votos
) { }
