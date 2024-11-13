package br.com.votacao.modules.associado.actions.cadastro.services.core;

import br.com.votacao.modules.associado.actions.cadastro.dto.request.CadastroAssociadoRequest;
import br.com.votacao.modules.associado.actions.cadastro.dto.request.mock.CadastroAssociadoRequestMock;
import br.com.votacao.modules.associado.actions.cadastro.dto.response.CadastroAssociadoResponse;
import br.com.votacao.modules.associado.actions.cadastro.dto.response.mock.CadastroAssociadoResponseMock;
import br.com.votacao.modules.associado.actions.cadastro.services.core.impl.CadastroAssociadoServiceImpl;
import br.com.votacao.modules.associado.actions.cadastro.services.mapper.CadastroAssociadoMapperService;
import br.com.votacao.modules.associado.actions.cadastro.services.validator.CadastroAssociadoValidatorService;
import br.com.votacao.modules.associado.entity.AssociadoEntity;
import br.com.votacao.modules.associado.entity.mock.AssociadoEntityMock;
import br.com.votacao.modules.associado.repository.AssociadoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("ServiceImpl: CadastroAssociado")
class CadastroAssociadoServiceImplTest {

    @InjectMocks
    CadastroAssociadoServiceImpl cadastroAssociadoServiceImpl;

    @Mock
    CadastroAssociadoValidatorService cadastroAssociadoValidatorService;

    @Mock
    CadastroAssociadoMapperService cadastroAssociadoMapperService;

    @Mock
    AssociadoRepository associadoRepository;

    @Test
    @DisplayName("Deve testar cadastro de novo associado")
    void deveTestarCadastroDeNovoAssociado() {

        CadastroAssociadoRequest cadastroAssociadoRequest = CadastroAssociadoRequestMock.builder().build();
        CadastroAssociadoResponse cadastroAssociadoResponse = CadastroAssociadoResponseMock.builder().build();
        AssociadoEntity associadoEntity = AssociadoEntityMock.builder().build();

        doNothing().when(cadastroAssociadoValidatorService).realizaValidacaoSeJaExisteUmAssociadoCadastradoComCpfInformado(any());

        when(cadastroAssociadoMapperService.geraAssociadoEntityAPartirDeCadastroAssociadoRequest(any())).thenReturn(associadoEntity);
        when(associadoRepository.save(any())).thenReturn(associadoEntity);
        when(cadastroAssociadoMapperService.geraAssociadoResponseAPartirDeAssociadoEntity(any())).thenReturn(cadastroAssociadoResponse);

        Assertions.assertDoesNotThrow(() ->
                cadastroAssociadoServiceImpl.realizaCadastroDeNovoAssociado(
                        cadastroAssociadoRequest
                )
        );
    }
}
