package br.com.votacao.modules.associado.actions.cadastro.controller.impl;

import br.com.votacao.modules.associado.actions.cadastro.dto.request.CadastroAssociadoRequest;
import br.com.votacao.modules.associado.actions.cadastro.dto.request.mock.CadastroAssociadoRequestMock;
import br.com.votacao.modules.associado.actions.cadastro.dto.response.CadastroAssociadoResponse;
import br.com.votacao.modules.associado.actions.cadastro.dto.response.mock.CadastroAssociadoResponseMock;
import br.com.votacao.modules.associado.actions.cadastro.services.core.CadastroAssociadoService;
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
@DisplayName("Controller: CadastroAssociado")
class CadastroAssociadoControllerTest {

    @InjectMocks
    CadastroAssociadoController cadastroAssociadoController;

    @Mock
    CadastroAssociadoService cadastroAssociadoService;

    @Test
    @DisplayName("Deve testar controller de cadastro de novo associado")
    void deveTestarControllerDeCadastroDeNovoAssociado() {

        CadastroAssociadoRequest cadastroAssociadoRequest = CadastroAssociadoRequestMock.builder().build();
        CadastroAssociadoResponse cadastroAssociadoResponse = CadastroAssociadoResponseMock.builder().build();

        when(cadastroAssociadoService.realizaCadastroDeNovoAssociado(any())).thenReturn(cadastroAssociadoResponse);

        ResponseEntity<CadastroAssociadoResponse> respostaServico =
                cadastroAssociadoController.criaNovoAssociado(
                        cadastroAssociadoRequest
                );

        Assertions.assertEquals(
                "<201 CREATED Created,CadastroAssociadoResponse[id=74bcd515-655c-4def-8dc8-3329ccbdf62e],[]>",
                respostaServico.toString()
        );

    }
}
