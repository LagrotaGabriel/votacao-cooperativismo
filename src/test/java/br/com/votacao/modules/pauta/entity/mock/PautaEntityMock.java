package br.com.votacao.modules.pauta.entity.mock;

import br.com.votacao.modules.pauta.entity.PautaEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class PautaEntityMock {

    private PautaEntity pautaEntity;

    private PautaEntityMock() {
    }

    public static PautaEntityMock builder() {

        PautaEntityMock builder = new PautaEntityMock();

        PautaEntity pauta = new PautaEntity();
        pauta.setId(UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e"));
        pauta.setTitulo("Legalização do @Data");
        pauta.setDescricao("Nessa pauta votaremos se o @Data deverá ou não ser legalizado nesta API");
        pauta.setTempoDuracaoEmMinutos(3);
        pauta.setDataHoraCriacao(LocalDateTime.of(2024, 11, 13, 15, 26, 0));
        pauta.setDataHoraExpiracao(LocalDateTime.of(2024, 11, 13, 15, 29, 0));
        pauta.setVotos(new ArrayList<>());

        builder.pautaEntity = pauta;

        return builder;
    }

    public PautaEntity build() {
        return pautaEntity;
    }
}
