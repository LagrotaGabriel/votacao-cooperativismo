package br.com.votacao.modules.voto.entity.mock;

import br.com.votacao.modules.associado.entity.mock.AssociadoEntityMock;
import br.com.votacao.modules.voto.entity.VotoEntity;
import br.com.votacao.modules.voto.entity.enums.TipoVotoEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VotoEntityMock {

    private VotoEntity votoEntity;

    private VotoEntityMock() {
    }

    public static VotoEntityMock builder() {

        VotoEntityMock builder = new VotoEntityMock();

        VotoEntity voto = new VotoEntity();
        voto.setId(UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e"));
        voto.setTipoVoto(TipoVotoEnum.SIM);
        voto.setDataHoraVoto(LocalDateTime.of(2024, 11, 13, 15, 26, 0));
        voto.setAssociado(AssociadoEntityMock.builder().build());

        builder.votoEntity = voto;

        return builder;
    }

    public List<VotoEntity> buildList() {

        List<VotoEntity> votoEntityList = new ArrayList<>();
        votoEntityList.add(this.votoEntity);

        return votoEntityList;
    }

    public VotoEntity build() {
        return votoEntity;
    }
}
