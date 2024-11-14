package br.com.votacao.modules.pauta.actions.obtencao.porid.models;

import br.com.votacao.modules.pauta.actions.obtencao.porid.models.mock.VotoPautaResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Response: VotoPauta")
class VotoPautaResponseTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        VotoPautaResponse votoPautaResponse = VotoPautaResponseMock.builder().build();

        Assertions.assertEquals(
                "VotoPautaResponse[tipoVoto=Sim, dataHoraVoto=2024-11-13T23:53, nomeAssociado=Gabriel Lagrota]",
                votoPautaResponse.toString()
        );
    }
}
