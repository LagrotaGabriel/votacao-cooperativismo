package br.com.votacao.modules.pauta.actions.obtencao.paginada.models;

import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.mock.ItemPautaPageResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("PageResponse: ItemPauta")
class ItemPautaPageResponseTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        ItemPautaPageResponse itemPautaPageResponse = ItemPautaPageResponseMock.builder().build();

        Assertions.assertEquals(
                "ItemPautaPageResponse[titulo=Legalização do @Data, descricao=Nessa pauta votaremos se o @Data " +
                        "deverá ou não ser legalizado nesta API, status=Encerrada, quantidadeVotosSim=2, " +
                        "quantidadesVotosNao=1, dataHoraCriacao=2024-11-13T23:56, dataHoraExpiracao=2024-11-13T23:57, " +
                        "votos=[VotosPautaPageResponse[tipoVoto=Sim, dataHoraVoto=2024-11-13T23:53, " +
                        "nomeAssociado=Gabriel Lagrota]]]",
                itemPautaPageResponse.toString()
        );
    }
}