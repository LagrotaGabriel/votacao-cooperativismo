package br.com.votacao.modules.cpf.controller;

import br.com.votacao.modules.cpf.controller.impl.ValidacaoCpfController;
import br.com.votacao.modules.cpf.models.request.CpfRequest;
import br.com.votacao.modules.cpf.models.request.mock.CpfRequestMock;
import br.com.votacao.modules.cpf.models.response.CpfResponse;
import br.com.votacao.modules.cpf.models.response.mock.CpfResponseMock;
import br.com.votacao.modules.cpf.services.ValidacaoCpfService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Controller: ValidacaoCpf")
class ValidacaoCpfControllerTest {

    @InjectMocks
    ValidacaoCpfController validacaoCpfController;

    @Mock
    ValidacaoCpfService validacaoCpfService;

    @Test
    @DisplayName("Deve testar controller de cadastro de nova Pauta")
    void deveTestarControllerDeCadastroDeNovaPauta() {

        CpfRequest cpfRequest = CpfRequestMock.builder().build();
        CpfResponse cpfResponse = CpfResponseMock.builder().build();

        when(validacaoCpfService.realizaValidacaoDeCpf(any())).thenReturn(cpfResponse);

        ResponseEntity<CpfResponse> respostaServico =
                validacaoCpfController.validaCpf(
                        cpfRequest
                );

        Assertions.assertEquals(
                "<200 OK OK,CpfResponse[status=ABLE_TO_VOTE, dataHoraChamada=2024-11-14T11:57],[]>",
                respostaServico.toString()
        );

    }
}
