package br.com.votacao.modules.pauta.actions.obtencao.paginada.services.core.impl;

import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.PautaPageResponse;
import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.mock.PautaPageResponseMock;
import br.com.votacao.modules.pauta.actions.obtencao.paginada.services.mapper.ObtencaoPaginadaPautaMapperService;
import br.com.votacao.modules.pauta.models.entity.PautaEntity;
import br.com.votacao.modules.pauta.entity.mock.PautaEntityMock;
import br.com.votacao.modules.pauta.repository.PautaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Service: ObtencaoPaginada")
class ObtencaoPaginadaPautaServiceImplTest {

    @InjectMocks
    ObtencaoPaginadaPautaServiceImpl obtencaoPaginadaPautaServiceImpl;

    @Mock
    ObtencaoPaginadaPautaMapperService obtencaoPaginadaPautaMapperService;

    @Mock
    PautaRepository pautaRepository;

    @Test
    @DisplayName("Deve testar obtenção paginada por pautas")
    void deveTestarObtencaoPaginadaPorPautas() {

        PautaEntity pautaEntityMock = PautaEntityMock.builder().build();
        List<PautaEntity> pautaEntityMockList = Collections.singletonList(pautaEntityMock);

        Pageable pageable = PageRequest.of(0, 10);
        Page<PautaEntity> pautaEntityPage = new PageImpl<>(pautaEntityMockList, pageable, pautaEntityMockList.size());

        PautaPageResponse pautaPageResponse = PautaPageResponseMock.builder().build();

        when(pautaRepository.save(any())).thenReturn(pautaEntityPage);
        when(obtencaoPaginadaPautaMapperService.realizaCriacaoDeObjetoPautaPageResponse(any())).thenReturn(pautaPageResponse);

        PautaPageResponse respostaServico =
                obtencaoPaginadaPautaServiceImpl.realizaObtencaoPaginadaPorPautas(
                        pageable
                );

        Assertions.assertEquals(
                "PautaPageResponse[conteudoPaginacao=[ItemPautaPageResponse[titulo=Legalização do @Data, " +
                        "descricao=Nessa pauta votaremos se o @Data deverá ou não ser legalizado nesta API, " +
                        "status=Encerrada, quantidadeVotosSim=2, quantidadesVotosNao=1, dataHoraCriacao=2024-11-13T23:56, " +
                        "dataHoraExpiracao=2024-11-13T23:57, votos=[VotosPautaPageResponse[tipoVoto=Sim, " +
                        "dataHoraVoto=2024-11-13T23:53, nomeAssociado=Gabriel Lagrota]]]], numberOfElements=7, " +
                        "pageNumber=0, pageSize=10, size=10, totalElements=7, totalPages=1]",
                respostaServico.toString()
        );
    }
}
