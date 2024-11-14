package br.com.votacao.modules.pauta.actions.obtencao.porid.models;

import java.time.LocalDateTime;

public record VotoPautaResponse(

        String tipoVoto,
        LocalDateTime dataHoraVoto,
        String nomeAssociado
) { }
