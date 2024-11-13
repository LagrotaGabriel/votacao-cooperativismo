package br.com.votacao.modules.voto.actions.cadastro.dto.request;

import br.com.votacao.modules.voto.actions.cadastro.dto.request.mock.CadastroVotoRequestMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Request: CadastroVoto")
class CadastroVotoRequestTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        CadastroVotoRequest cadastroVotoRequest = CadastroVotoRequestMock.builder().build();

        Assertions.assertEquals(
                "CadastroVotoRequest[voto=SIM, idAssociado=8429be2a-fd36-4d30-ac69-d79661e42eb4]",
                cadastroVotoRequest.toString()
        );
    }
}
