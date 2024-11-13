package br.com.votacao.modules.pauta.actions.cadastro.dto.request;

import br.com.votacao.modules.pauta.actions.cadastro.dto.request.mock.CadastroPautaRequestMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Request: CadastroPauta")
class CadastroPautaRequestTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        CadastroPautaRequest cadastroPautaRequest = CadastroPautaRequestMock.builder().build();

        Assertions.assertEquals(
                "CadastroPautaRequest[titulo=Legalização do @Data, descricao=Nessa pauta votaremos se o " +
                        "@Data deverá ou não ser legalizado nesta API, duracaoEmMinutos=5]",
                cadastroPautaRequest.toString()
        );
    }
}
