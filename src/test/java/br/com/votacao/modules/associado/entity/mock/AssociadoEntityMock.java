package br.com.votacao.modules.associado.entity.mock;

import br.com.votacao.modules.associado.entity.AssociadoEntity;

import java.util.UUID;

public class AssociadoEntityMock {

    private AssociadoEntity associadoEntity;

    private AssociadoEntityMock() {
    }

    public static AssociadoEntityMock builder() {

        AssociadoEntityMock builder = new AssociadoEntityMock();

        AssociadoEntity associado = new AssociadoEntity();
        associado.setId(UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e"));
        associado.setNome("Gabriel Lagrota");
        associado.setCpf("123.189.265-38");

        builder.associadoEntity = associado;

        return builder;
    }

    public AssociadoEntity build() {
        return associadoEntity;
    }
}
