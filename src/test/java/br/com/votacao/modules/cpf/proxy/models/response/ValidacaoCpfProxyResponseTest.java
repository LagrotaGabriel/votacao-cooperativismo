package br.com.votacao.modules.cpf.proxy.models.response;

import br.com.votacao.modules.cpf.proxy.models.response.mock.ValidacaoCpfProxyResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("ProxyResponse: ValidacaoCpf")
class ValidacaoCpfProxyResponseTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        ValidacaoCpfProxyResponse validacaoCpfProxyResponse = ValidacaoCpfProxyResponseMock.builder().build();

        Assertions.assertEquals(
                "ValidacaoCpfProxyResponse[status=ABLE_TO_VOTE]",
                validacaoCpfProxyResponse.toString()
        );
    }
}