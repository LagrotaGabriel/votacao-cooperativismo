package br.com.votacao.modules.pauta.actions.obtencao.porid.models;

import br.com.votacao.modules.pauta.actions.obtencao.porid.models.mock.PautaResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Response: Pauta")
class PautaResponseTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        PautaResponse pautaResponse = PautaResponseMock.builder().build();

        Assertions.assertEquals(
                "PautaResponse[titulo=Legalização do @Data, descricao=Nessa pauta votaremos se o @Data deverá " +
                        "ou não ser legalizado nesta API, status=Encerrada, quantidadeVotosSim=1, quantidadesVotosNao=0, " +
                        "dataHoraCriacao=2024-11-14T09:13, dataHoraExpiracao=2024-11-14T09:13, " +
                        "votos=[VotoPautaResponse[tipoVoto=Sim, dataHoraVoto=2024-11-13T23:53, " +
                        "nomeAssociado=Gabriel Lagrota]]]",
                pautaResponse.toString()
        );
    }
}
