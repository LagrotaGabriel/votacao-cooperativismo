package br.com.votacao.modules.associado.actions.cadastro.dto.response;

import br.com.votacao.modules.associado.actions.cadastro.dto.response.mock.CadastroAssociadoResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Response: CadastroAssociado")
class CadastroAssociadoResponseTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        CadastroAssociadoResponse cadastroAssociadoResponse = CadastroAssociadoResponseMock.builder().build();

        Assertions.assertEquals(
                "CadastroAssociadoResponse[id=74bcd515-655c-4def-8dc8-3329ccbdf62e]",
                cadastroAssociadoResponse.toString()
        );
    }
}
