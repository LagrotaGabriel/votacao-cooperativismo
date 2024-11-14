package br.com.votacao.modules.cpf.models.response;

import br.com.votacao.modules.cpf.models.response.mock.CpfResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Response: CPF")
class CpfResponseTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        CpfResponse cpfResponse = CpfResponseMock.builder().build();

        Assertions.assertEquals(
                "CpfResponse[status=ABLE_TO_VOTE, dataHoraChamada=2024-11-14T11:57]",
                cpfResponse.toString()
        );
    }
}
