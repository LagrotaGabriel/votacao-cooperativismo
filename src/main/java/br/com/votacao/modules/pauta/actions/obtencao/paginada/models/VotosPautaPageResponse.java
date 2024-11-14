package br.com.votacao.modules.pauta.actions.obtencao.paginada.models;

import java.time.LocalDateTime;

public record VotosPautaPageResponse(

        String tipoVoto,
        LocalDateTime dataHoraVoto,
        String nomeAssociado
) { }
