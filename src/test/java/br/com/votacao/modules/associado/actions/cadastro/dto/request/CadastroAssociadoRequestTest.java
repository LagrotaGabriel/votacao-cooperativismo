package br.com.votacao.modules.associado.actions.cadastro.dto.request;

import br.com.votacao.modules.associado.actions.cadastro.dto.request.mock.CadastroAssociadoRequestMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Request: CadastroAssociado")
class CadastroAssociadoRequestTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        CadastroAssociadoRequest cadastroAssociadoRequest = CadastroAssociadoRequestMock.builder().build();

        Assertions.assertEquals(
                "CadastroAssociadoRequest[nome=Gabriel, cpf=472.535.279-22]",
                cadastroAssociadoRequest.toString()
        );
    }
}
