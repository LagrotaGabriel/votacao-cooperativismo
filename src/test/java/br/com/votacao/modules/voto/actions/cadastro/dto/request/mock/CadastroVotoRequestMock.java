package br.com.votacao.modules.voto.actions.cadastro.dto.request.mock;

import br.com.votacao.modules.voto.actions.cadastro.dto.request.CadastroVotoRequest;
import br.com.votacao.modules.voto.entity.enums.TipoVotoEnum;

import java.util.UUID;

public class CadastroVotoRequestMock {

    private CadastroVotoRequest cadastroVotoRequest;

    private CadastroVotoRequestMock() {
    }

    public static CadastroVotoRequestMock builder() {

        CadastroVotoRequestMock builder = new CadastroVotoRequestMock();

        builder.cadastroVotoRequest =
                new CadastroVotoRequest(
                        TipoVotoEnum.SIM,
                        UUID.fromString("8429be2a-fd36-4d30-ac69-d79661e42eb4")
                );

        return builder;
    }

    public CadastroVotoRequest build() {
        return cadastroVotoRequest;
    }
}
