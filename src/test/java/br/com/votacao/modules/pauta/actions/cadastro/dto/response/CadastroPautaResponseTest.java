package br.com.votacao.modules.pauta.actions.cadastro.dto.response;

import br.com.votacao.modules.pauta.actions.cadastro.dto.response.mock.CadastroPautaResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Response: CadastroPauta")
class CadastroPautaResponseTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        CadastroPautaResponse cadastroPautaResponse = CadastroPautaResponseMock.builder().build();

        Assertions.assertEquals(
                "CadastroPautaResponse[id=74bcd515-655c-4def-8dc8-3329ccbdf62e, titulo=Legalização do @Data, " +
                        "descricao=Nessa pauta votaremos se o @Data deverá ou não ser legalizado nesta API, " +
                        "dataHoraexpiracaoPauta=2024-11-13T15:37]",
                cadastroPautaResponse.toString()
        );
    }
}
