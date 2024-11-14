package br.com.votacao.modules.cpf.services;

import br.com.votacao.modules.cpf.models.request.CpfRequest;
import br.com.votacao.modules.cpf.models.request.mock.CpfRequestMock;
import br.com.votacao.modules.cpf.proxy.ValidacaoCpfProxy;
import br.com.votacao.modules.cpf.proxy.models.response.ValidacaoCpfProxyResponse;
import br.com.votacao.modules.cpf.proxy.models.response.mock.ValidacaoCpfProxyResponseMock;
import br.com.votacao.modules.cpf.services.impl.ValidacaoCpfServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Service: ValidacaoCpf")
class ValidacaoCpfServiceTest {

    @InjectMocks
    ValidacaoCpfServiceImpl validacaoCpfServiceImpl;

    @Mock
    ValidacaoCpfProxy validacaoCpfProxy;

    @Test
    @DisplayName("Deve testar validação de CPF com sucesso")
    void deveTestarValidacaoDeCpfComSucesso() {

        ValidacaoCpfProxyResponse validacaoCpfProxyResponseMock = ValidacaoCpfProxyResponseMock.builder().build();
        CpfRequest cpfRequest = CpfRequestMock.builder().build();

        when(validacaoCpfProxy.realizaValidacaoDeCpfNaIntegradora(any())).thenReturn(ResponseEntity.ok(validacaoCpfProxyResponseMock));

        Assertions.assertDoesNotThrow(() -> validacaoCpfServiceImpl.realizaValidacaoDeCpf(cpfRequest));
    }

    @Test
    @DisplayName("Deve testar validação de CPF sem body retornado pela integradora")
    void deveTestarValidacaoDeCpfSemBodyRetornadoPelaIntegradora() {

        CpfRequest cpfRequest = CpfRequestMock.builder().build();

        when(validacaoCpfProxy.realizaValidacaoDeCpfNaIntegradora(any())).thenReturn(ResponseEntity.ok(null));

        Assertions.assertThrows((InternalError.class), () -> validacaoCpfServiceImpl.realizaValidacaoDeCpf(cpfRequest));
    }

    @Test
    @DisplayName("Deve testar validação de CPF com captura de exception")
    void deveTestarValidacaoDeCpfComCapturaDeException() {

        CpfRequest cpfRequest = CpfRequestMock.builder().build();

        doThrow(new RuntimeException("Erro interno mock"))
                .when(validacaoCpfProxy)
                .realizaValidacaoDeCpfNaIntegradora(any());

        Assertions.assertDoesNotThrow(() -> validacaoCpfServiceImpl.realizaValidacaoDeCpf(cpfRequest));
    }
}
