package br.com.votacao.modules.cpf.models.response;

import br.com.votacao.modules.cpf.proxy.models.enums.StatusValidacaoCpfEnum;

import java.time.LocalDateTime;

public record CpfResponse(

        StatusValidacaoCpfEnum status,
        LocalDateTime dataHoraChamada
) { }
