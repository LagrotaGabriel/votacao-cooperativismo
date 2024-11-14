package br.com.votacao.modules.pauta.actions.cadastro.services.core.impl;

import br.com.votacao.modules.pauta.actions.cadastro.dto.request.CadastroPautaRequest;
import br.com.votacao.modules.pauta.actions.cadastro.dto.request.mock.CadastroPautaRequestMock;
import br.com.votacao.modules.pauta.actions.cadastro.dto.response.CadastroPautaResponse;
import br.com.votacao.modules.pauta.actions.cadastro.dto.response.mock.CadastroPautaResponseMock;
import br.com.votacao.modules.pauta.actions.cadastro.services.mapper.CadastroPautaMapperService;
import br.com.votacao.modules.pauta.models.entity.PautaEntity;
import br.com.votacao.modules.pauta.entity.mock.PautaEntityMock;
import br.com.votacao.modules.pauta.repository.PautaRepository;
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
@DisplayName("Service: CadastroPauta")
class CadastroPautaServiceImplTest {

    @InjectMocks
    CadastroPautaServiceImpl cadastroPautaServiceImpl;

    @Mock
    CadastroPautaMapperService cadastroPautaMapperService;

    @Mock
    PautaRepository pautaRepository;

    @Test
    @DisplayName("Deve testar cadastro de pauta")
    void deveTestarCadastroDePauta() {

        CadastroPautaRequest cadastroPautaRequest = CadastroPautaRequestMock.builder().build();
        CadastroPautaResponse cadastroPautaResponse = CadastroPautaResponseMock.builder().build();
        PautaEntity pautaEntity = PautaEntityMock.builder().build();

        when(cadastroPautaMapperService.geraPautaEntityAPartirDeCadastroPautaRequest(any())).thenReturn(pautaEntity);
        when(pautaRepository.save(any())).thenReturn(pautaEntity);
        when(cadastroPautaMapperService.geraPautaResponseAPartirDePautaEntity(any())).thenReturn(cadastroPautaResponse);

        Assertions.assertDoesNotThrow(() ->
                cadastroPautaServiceImpl.realizaCadastroDeNovaPauta(
                        cadastroPautaRequest
                )
        );
    }
}
