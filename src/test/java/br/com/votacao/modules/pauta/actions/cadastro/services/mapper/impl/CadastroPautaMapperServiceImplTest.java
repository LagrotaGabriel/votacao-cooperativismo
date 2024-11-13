package br.com.votacao.modules.pauta.actions.cadastro.services.mapper.impl;

import br.com.votacao.modules.pauta.actions.cadastro.dto.request.CadastroPautaRequest;
import br.com.votacao.modules.pauta.actions.cadastro.dto.request.mock.CadastroPautaRequestMock;
import br.com.votacao.modules.pauta.actions.cadastro.dto.response.CadastroPautaResponse;
import br.com.votacao.modules.pauta.entity.PautaEntity;
import br.com.votacao.modules.pauta.entity.mock.PautaEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("MapperService: CadastroPauta")
class CadastroPautaMapperServiceImplTest {

    @InjectMocks
    CadastroPautaMapperServiceImpl cadastroPautaMapperServiceImpl;

    @Test
    @DisplayName("Deve testar geração de PautaEntity a partir de CadastroPautaRequest")
    void deveTestarGeracaoDePautaEntityAPartirDeCadastroPautaRequest() {

        CadastroPautaRequest cadastroPautaRequest = CadastroPautaRequestMock.builder().build();

        PautaEntity pautaEntity =
                cadastroPautaMapperServiceImpl.geraPautaEntityAPartirDeCadastroPautaRequest(
                        cadastroPautaRequest
                );

        Assertions.assertNotNull(
                pautaEntity
        );
    }

    @Test
    @DisplayName("Deve testar geração de PautaEntity a partir de CadastroPautaRequest sem minutos informados")
    void deveTestarGeracaoDePautaEntityAPartirDeCadastroPautaRequestSemMinutosInformados() {

        CadastroPautaRequest cadastroPautaRequest = CadastroPautaRequestMock.builder().semMinutosInformados().build();

        PautaEntity pautaEntity =
                cadastroPautaMapperServiceImpl.geraPautaEntityAPartirDeCadastroPautaRequest(
                        cadastroPautaRequest
                );

        Assertions.assertNotNull(
                pautaEntity
        );
    }

    @Test
    @DisplayName("Deve testar geração de PautaResponse a partir de PautaEntity")
    void deveTestarGeracaoDePautaResponseAPartirDePautaEntity() {

        PautaEntity pautaEntity = PautaEntityMock.builder().build();

        CadastroPautaResponse cadastroPautaResponse =
                cadastroPautaMapperServiceImpl.geraPautaResponseAPartirDePautaEntity(
                        pautaEntity
                );

        Assertions.assertNotNull(
                cadastroPautaResponse
        );
    }
}
