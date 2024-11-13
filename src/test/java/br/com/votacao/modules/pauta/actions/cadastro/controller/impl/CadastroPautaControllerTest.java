package br.com.votacao.modules.pauta.actions.cadastro.controller.impl;

import br.com.votacao.modules.pauta.actions.cadastro.dto.request.CadastroPautaRequest;
import br.com.votacao.modules.pauta.actions.cadastro.dto.request.mock.CadastroPautaRequestMock;
import br.com.votacao.modules.pauta.actions.cadastro.dto.response.CadastroPautaResponse;
import br.com.votacao.modules.pauta.actions.cadastro.dto.response.mock.CadastroPautaResponseMock;
import br.com.votacao.modules.pauta.actions.cadastro.services.core.CadastroPautaService;
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
@DisplayName("Controller: CadastroPauta")
class CadastroPautaControllerTest {

    @InjectMocks
    CadastroPautaController cadastroPautaController;

    @Mock
    CadastroPautaService cadastroPautaService;

    @Test
    @DisplayName("Deve testar controller de cadastro de nova Pauta")
    void deveTestarControllerDeCadastroDeNovaPauta() {

        CadastroPautaRequest cadastroPautaRequest = CadastroPautaRequestMock.builder().build();
        CadastroPautaResponse cadastroPautaResponse = CadastroPautaResponseMock.builder().build();

        when(cadastroPautaService.realizaCadastroDeNovaPauta(any())).thenReturn(cadastroPautaResponse);

        ResponseEntity<CadastroPautaResponse> respostaServico =
                cadastroPautaController.criaNovaPauta(
                        cadastroPautaRequest
                );

        Assertions.assertEquals(
                "",
                respostaServico.toString()
        );

    }
}
