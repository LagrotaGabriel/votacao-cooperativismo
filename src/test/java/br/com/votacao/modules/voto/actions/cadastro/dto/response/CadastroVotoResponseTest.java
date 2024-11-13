package br.com.votacao.modules.voto.actions.cadastro.dto.response;

import br.com.votacao.modules.voto.actions.cadastro.dto.response.mock.CadastroVotoResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Response: CadastroVoto")
class CadastroVotoResponseTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        CadastroVotoResponse cadastroVotoResponse = CadastroVotoResponseMock.builder().build();

        Assertions.assertEquals(
                "CadastroVotoResponse[idVoto=74bcd515-655c-4def-8dc8-3329ccbdf62e, quantidadeDeVotosComputados=5]",
                cadastroVotoResponse.toString()
        );
    }
}
