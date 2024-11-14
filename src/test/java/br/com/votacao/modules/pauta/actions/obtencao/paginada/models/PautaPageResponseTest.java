package br.com.votacao.modules.pauta.actions.obtencao.paginada.models;

import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.mock.PautaPageResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("PageResponse: Pauta")
class PautaPageResponseTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        PautaPageResponse pautaPageResponse =  PautaPageResponseMock.builder().build();

        Assertions.assertEquals(
                "PautaPageResponse[conteudoPaginacao=[" +
                        "ItemPautaPageResponse[id=f2ac6801-6cad-4408-b002-31d00314f493, titulo=Legalização do @Data, " +
                        "descricao=Nessa pauta votaremos se o @Data deverá ou não ser legalizado nesta API, " +
                        "status=Encerrada, quantidadeDeVotos=3, quantidadeVotosSim=2, quantidadesVotosNao=1, " +
                        "dataHoraCriacao=2024-11-13T23:56, dataHoraExpiracao=2024-11-13T23:57]], numberOfElements=7, " +
                        "pageNumber=0, pageSize=10, size=10, totalElements=7, totalPages=1]",
                pautaPageResponse.toString()
        );
    }
}
