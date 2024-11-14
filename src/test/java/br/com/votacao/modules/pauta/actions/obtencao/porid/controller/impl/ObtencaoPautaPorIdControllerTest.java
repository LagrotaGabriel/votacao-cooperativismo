package br.com.votacao.modules.pauta.actions.obtencao.porid.controller.impl;

import br.com.votacao.modules.pauta.actions.obtencao.porid.models.PautaResponse;
import br.com.votacao.modules.pauta.actions.obtencao.porid.models.mock.PautaResponseMock;
import br.com.votacao.modules.pauta.actions.obtencao.porid.services.core.ObtencaoPautaPorIdService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Controller: ObtencaoPautaPorId")
class ObtencaoPautaPorIdControllerTest {

    @InjectMocks
    ObtencaoPautaPorIdController obtencaoPautaPorIdController;

    @Mock
    ObtencaoPautaPorIdService obtencaoPautaPorIdService;

    @Test
    @DisplayName("Deve testar controller de obtencao paginada de pautas")
    void deveTestarControllerDeObtencaoPaginadaDePautas() {

        PautaResponse pautaResponse = PautaResponseMock.builder().build();

        when(obtencaoPautaPorIdService.realizaObtencaoDePautaPorId(any())).thenReturn(pautaResponse);

        ResponseEntity<PautaResponse> respostaServico =
                obtencaoPautaPorIdController.realizaObtencaoDePautaPorId(
                        UUID.fromString("f2ac6801-6cad-4408-b002-31d00314f493")
                );

        Assertions.assertEquals(
                "<200 OK OK,PautaResponse[titulo=Legalização do @Data, descricao=Nessa pauta votaremos se o " +
                        "@Data deverá ou não ser legalizado nesta API, status=Encerrada, quantidadeVotosSim=1, " +
                        "quantidadesVotosNao=0, dataHoraCriacao=2024-11-14T09:13, dataHoraExpiracao=2024-11-14T09:13, " +
                        "votos=[VotoPautaResponse[tipoVoto=Sim, dataHoraVoto=2024-11-13T23:53, " +
                        "nomeAssociado=Gabriel Lagrota]]],[]>",
                respostaServico.toString()
        );

    }
}
