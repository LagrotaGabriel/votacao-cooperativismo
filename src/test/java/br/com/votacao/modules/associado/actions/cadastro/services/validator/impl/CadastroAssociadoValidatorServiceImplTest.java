package br.com.votacao.modules.associado.actions.cadastro.services.validator.impl;

import br.com.votacao.modules.associado.actions.cadastro.dto.request.mock.CadastroAssociadoRequestMock;
import br.com.votacao.modules.associado.actions.cadastro.services.validator.exceptions.CpfDoAssociadoJaExisteException;
import br.com.votacao.modules.associado.repository.AssociadoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("ServiceImpl: CadastroAssociadoValidator")
class CadastroAssociadoValidatorServiceImplTest {

    @InjectMocks
    CadastroAssociadoValidatorServiceImpl cadastroAssociadoValidatorServiceImpl;

    @Mock
    AssociadoRepository associadoRepository;

    @Test
    @DisplayName("Deve testar validação se CPF do associado já existe com lançamento de exception")
    void deveTestarValidacaoSeCpfJaExistenteDoAssociadoComLancamentoDeException() {

        String cpf = CadastroAssociadoRequestMock.builder().build().cpf();

        when(associadoRepository.verificaSeJaExisteUmAssociadoCadastradoComCpfInformado(any())).thenReturn(true);

        Assertions.assertThrows((CpfDoAssociadoJaExisteException.class), () ->
                cadastroAssociadoValidatorServiceImpl.realizaValidacaoSeJaExisteUmAssociadoCadastradoComCpfInformado(
                        cpf
                )
        );
    }

    @Test
    @DisplayName("Deve testar validação se CPF do associado já existe com lançamento de sucesso")
    void deveTestarValidacaoSeCpfJaExistenteDoAssociadoComSucesso() {

        String cpf = CadastroAssociadoRequestMock.builder().build().cpf();

        when(associadoRepository.verificaSeJaExisteUmAssociadoCadastradoComCpfInformado(any())).thenReturn(false);

        Assertions.assertDoesNotThrow(() ->
                cadastroAssociadoValidatorServiceImpl.realizaValidacaoSeJaExisteUmAssociadoCadastradoComCpfInformado(
                        cpf
                )
        );

    }

}
