package br.com.votacao.modules.cpf.models.request;

import br.com.votacao.modules.cpf.models.request.mock.CpfRequestMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Request: CPF")
class CpfRequestTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        CpfRequest cpfRequest = CpfRequestMock.builder().build();

        Assertions.assertEquals(
                "CpfRequest[cpf=111.111.111-11]",
                cpfRequest.toString()
        );
    }
}
