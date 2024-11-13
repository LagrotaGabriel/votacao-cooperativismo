package br.com.votacao.modules.voto.actions.cadastro.services.mapper.impl;

import br.com.votacao.modules.associado.entity.AssociadoEntity;
import br.com.votacao.modules.associado.entity.mock.AssociadoEntityMock;
import br.com.votacao.modules.pauta.entity.PautaEntity;
import br.com.votacao.modules.pauta.entity.mock.PautaEntityMock;
import br.com.votacao.modules.voto.actions.cadastro.dto.request.CadastroVotoRequest;
import br.com.votacao.modules.voto.actions.cadastro.dto.request.mock.CadastroVotoRequestMock;
import br.com.votacao.modules.voto.actions.cadastro.dto.response.CadastroVotoResponse;
import br.com.votacao.modules.voto.entity.VotoEntity;
import br.com.votacao.modules.voto.entity.mock.VotoEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("MapperService: Cadastro voto")
class CadastroVotoMapperServiceImplTest {

    @InjectMocks
    CadastroVotoMapperServiceImpl cadastroVotoMapperServiceImpl;

    @Test
    @DisplayName("Deve testar geração de VotoEntity a partir de CadastroVotoRequest sem minutos informados")
    void deveTestarGeracaoDeVotoEntityAPartirDeCadastroVotoRequestSemMinutosInformados() {

        CadastroVotoRequest cadastroVotoRequest = CadastroVotoRequestMock.builder().build();

        AssociadoEntity associadoEntity = AssociadoEntityMock.builder().build();

        VotoEntity votoEntity =
                cadastroVotoMapperServiceImpl.geraVotoEntityAPartirDeCadastroVotoRequest(
                        cadastroVotoRequest,
                        associadoEntity
                );

        Assertions.assertNotNull(
                votoEntity
        );
    }

    @Test
    @DisplayName("Deve testar geração de VotoResponse a partir de VotoEntity")
    void deveTestarGeracaoDeVotoResponseAPartirDeVotoEntity() {

        PautaEntity pautaEntity = PautaEntityMock.builder().build();
        VotoEntity votoEntity = VotoEntityMock.builder().build();

        CadastroVotoResponse cadastroVotoResponse =
                cadastroVotoMapperServiceImpl.geraVotoResponseAPartirDeVotoEntity(
                        pautaEntity,
                        votoEntity
                );

        Assertions.assertNotNull(
                cadastroVotoResponse
        );
    }
}
