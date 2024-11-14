package br.com.votacao.modules.pauta.actions.obtencao.paginada.models;

import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.mock.VotosPautaPageResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("PageResponse: VotosPauta")
class VotosPautaPageResponseTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        VotosPautaPageResponse votosPautaPageResponse = VotosPautaPageResponseMock.builder().build();

        Assertions.assertEquals(
                "VotosPautaPageResponse[tipoVoto=Sim, dataHoraVoto=2024-11-13T23:53, nomeAssociado=Gabriel Lagrota]",
                votosPautaPageResponse.toString()
        );
    }
}
