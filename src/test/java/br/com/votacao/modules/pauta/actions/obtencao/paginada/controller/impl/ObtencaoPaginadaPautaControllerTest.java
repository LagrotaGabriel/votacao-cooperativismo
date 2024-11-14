package br.com.votacao.modules.pauta.actions.obtencao.paginada.controller.impl;

import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.PautaPageResponse;
import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.mock.PautaPageResponseMock;
import br.com.votacao.modules.pauta.actions.obtencao.paginada.services.core.ObtencaoPaginadaPautaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Controller: ObtencaoPaginadaPauta")
class ObtencaoPaginadaPautaControllerTest {

    @InjectMocks
    ObtencaoPaginadaPautaController obtencaoPaginadaPautaController;

    @Mock
    ObtencaoPaginadaPautaService obtencaoPaginadaPautaService;

    @Test
    @DisplayName("Deve testar controller de obtencao paginada de pautas")
    void deveTestarControllerDeObtencaoPaginadaDePautas() {

        Pageable pageable = PageRequest.of(0, 10);

        PautaPageResponse pautaPageResponseMock = PautaPageResponseMock.builder().build();

        when(obtencaoPaginadaPautaService.realizaObtencaoPaginadaPorPautas(any())).thenReturn(pautaPageResponseMock);

        ResponseEntity<PautaPageResponse> respostaServico =
                obtencaoPaginadaPautaController.realizaObtencaoPaginadaPorPautas(
                        pageable
                );

        Assertions.assertEquals(
                "<200 OK OK,PautaPageResponse[conteudoPaginacao=[" +
                        "ItemPautaPageResponse[id=f2ac6801-6cad-4408-b002-31d00314f493, titulo=Legalização do @Data, " +
                        "descricao=Nessa pauta votaremos se o @Data deverá ou não ser legalizado nesta API, " +
                        "status=Encerrada, quantidadeDeVotos=3, quantidadeVotosSim=2, quantidadesVotosNao=1, " +
                        "dataHoraCriacao=2024-11-13T23:56, dataHoraExpiracao=2024-11-13T23:57]], numberOfElements=7, " +
                        "pageNumber=0, pageSize=10, size=10, totalElements=7, totalPages=1],[]>",
                respostaServico.toString()
        );

    }
}
