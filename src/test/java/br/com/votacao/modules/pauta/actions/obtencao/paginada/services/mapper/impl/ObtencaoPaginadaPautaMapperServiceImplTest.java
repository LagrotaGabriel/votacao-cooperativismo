package br.com.votacao.modules.pauta.actions.obtencao.paginada.services.mapper.impl;

import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.ItemPautaPageResponse;
import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.PautaPageResponse;
import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.VotosPautaPageResponse;
import br.com.votacao.modules.pauta.models.entity.PautaEntity;
import br.com.votacao.modules.pauta.entity.mock.PautaEntityMock;
import br.com.votacao.modules.voto.entity.VotoEntity;
import br.com.votacao.modules.voto.entity.mock.VotoEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("MapperService: ObtencaoPaginadaPauta")
class ObtencaoPaginadaPautaMapperServiceImplTest {

    @InjectMocks
    ObtencaoPaginadaPautaMapperServiceImpl obtencaoPaginadaPautaMapperServiceImpl;

    @Test
    @DisplayName("Deve testar criação de objeto PautaPageResponse")
    void deveTestarCriacaoDeObjetoPautaPageResponse() {

        PautaEntity pautaEntityMock = PautaEntityMock.builder().build();
        List<PautaEntity> pautaEntityMockList = Collections.singletonList(pautaEntityMock);

        Pageable pageable = PageRequest.of(0, 10);
        Page<PautaEntity> pautaEntityPage = new PageImpl<>(pautaEntityMockList, pageable, pautaEntityMockList.size());

        PautaPageResponse pautaPageResponse =
                obtencaoPaginadaPautaMapperServiceImpl.realizaCriacaoDeObjetoPautaPageResponse(
                        pautaEntityPage
                );

        Assertions.assertNotNull(
                pautaPageResponse
        );
    }

    @Test
    @DisplayName("Deve testar geração de ItemPautaPageResponse")
    void deveTestarGeracaoDeItemPautaPageResponse() {

        List<PautaEntity> pautaEntityList = new ArrayList<>();
        PautaEntity pautaEntityMockEmAberto = PautaEntityMock.builder().ComDataDeExpiracaoNoFuturo().build();
        PautaEntity pautaEntityMockEncerrado = PautaEntityMock.builder().build();

        pautaEntityList.add(pautaEntityMockEmAberto);
        pautaEntityList.add(pautaEntityMockEncerrado);

        List<ItemPautaPageResponse> itemPautaPageResponseList =
                obtencaoPaginadaPautaMapperServiceImpl.geraListaDeItemPautaPageResponse(
                        pautaEntityList
                );

        Assertions.assertNotNull(
                itemPautaPageResponseList.toString()
        );
    }

    @Test
    @DisplayName("Deve testar geração de lista de votos")
    void deveTestarGeracaoDeListaDeVotos() {

        List<VotoEntity> votoEntityList = VotoEntityMock.builder().buildList();

        List<VotosPautaPageResponse> votosPautaPageResponseList =
                obtencaoPaginadaPautaMapperServiceImpl.geraListaDeVotos(
                        votoEntityList
                );

        Assertions.assertEquals(
                "[VotosPautaPageResponse[tipoVoto=Sim, dataHoraVoto=2024-11-13T15:26, nomeAssociado=Gabriel Lagrota]]",
                votosPautaPageResponseList.toString()
        );
    }
}
