package br.com.votacao.modules.pauta.actions.obtencao.porid.services.mapper.impl;

import br.com.votacao.modules.pauta.actions.obtencao.porid.models.PautaResponse;
import br.com.votacao.modules.pauta.actions.obtencao.porid.models.VotoPautaResponse;
import br.com.votacao.modules.pauta.entity.mock.PautaEntityMock;
import br.com.votacao.modules.pauta.models.entity.PautaEntity;
import br.com.votacao.modules.voto.entity.VotoEntity;
import br.com.votacao.modules.voto.entity.mock.VotoEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("ServiceImpl: ObtencaoPautaPorId")
class ObtencaoPautaPorIdMapperServiceImplTest {

    @InjectMocks
    ObtencaoPautaPorIdMapperServiceImpl obtencaoPautaPorIdMapperServiceImpl;

    @Test
    @DisplayName("Deve testar criação de objeto PautaResponse")
    void deveTestarCriacaoDeObjetoPautaResponse() {

        PautaEntity pautaEntityMock = PautaEntityMock.builder().build();

        PautaResponse pautaResponse =
                obtencaoPautaPorIdMapperServiceImpl.realizaCriacaoDeObjetoPautaResponse(
                        pautaEntityMock
                );

        Assertions.assertNotNull(
                pautaResponse
        );
    }

    @Test
    @DisplayName("Deve testar criação de objeto PautaResponse com pauta em aberto")
    void deveTestarCriacaoDeObjetoPautaResponseComPautaEmAberto() {

        PautaEntity pautaEntityMock = PautaEntityMock.builder().ComDataDeExpiracaoNoFuturo().build();

        PautaResponse pautaResponse =
                obtencaoPautaPorIdMapperServiceImpl.realizaCriacaoDeObjetoPautaResponse(
                        pautaEntityMock
                );

        Assertions.assertNotNull(
                pautaResponse
        );
    }

    @Test
    @DisplayName("Deve testar geração de lista de votos")
    void deveTestarGeracaoDeListaDeVotos() {

        List<VotoEntity> votoEntityList = VotoEntityMock.builder().buildList();

        List<VotoPautaResponse> votosPautaPageResponseList =
                obtencaoPautaPorIdMapperServiceImpl.geraListaDeVotos(
                        votoEntityList
                );

        Assertions.assertEquals(
                "[VotoPautaResponse[tipoVoto=Sim, dataHoraVoto=2024-11-13T15:26, nomeAssociado=Gabriel Lagrota]]",
                votosPautaPageResponseList.toString()
        );
    }
}
