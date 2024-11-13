package br.com.votacao.modules.associado.actions.cadastro.services.mapper.impl;

import br.com.votacao.modules.associado.actions.cadastro.dto.request.CadastroAssociadoRequest;
import br.com.votacao.modules.associado.actions.cadastro.dto.request.mock.CadastroAssociadoRequestMock;
import br.com.votacao.modules.associado.actions.cadastro.dto.response.CadastroAssociadoResponse;
import br.com.votacao.modules.associado.entity.AssociadoEntity;
import br.com.votacao.modules.associado.entity.mock.AssociadoEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("MapperService: CadastroAssociado")
class CadastroAssociadoMapperServiceImplTest {

    @InjectMocks
    CadastroAssociadoMapperServiceImpl cadastroAssociadoMapperService;

    @Test
    @DisplayName("Deve testar geração de AssociadoEntity a partir de CadastroAssociadoRequest")
    void deveTestarGeracaoDeAssociadoEntityAPartirDeCadastroAssociadoRequest() {

        CadastroAssociadoRequest cadastroAssociadoRequest = CadastroAssociadoRequestMock.builder().build();

        AssociadoEntity associadoEntity =
                cadastroAssociadoMapperService.geraAssociadoEntityAPartirDeCadastroAssociadoRequest(
                        cadastroAssociadoRequest
                );

        Assertions.assertNotNull(
                associadoEntity
        );
    }

    @Test
    @DisplayName("Deve testar geração de CadastroAssociadoResponse a partir de AssociadoEntity")
    void deveTestarGeracaoDeCadastroAssociadoResponseAPartirDeAssociadoEntity() {

        AssociadoEntity associadoEntity = AssociadoEntityMock.builder().build();

        CadastroAssociadoResponse cadastroAssociadoResponse =
                cadastroAssociadoMapperService.geraAssociadoResponseAPartirDeAssociadoEntity(
                        associadoEntity
                );

        Assertions.assertNotNull(
                cadastroAssociadoResponse
        );
    }
}
