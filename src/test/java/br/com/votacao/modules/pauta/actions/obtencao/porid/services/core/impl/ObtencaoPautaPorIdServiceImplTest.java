package br.com.votacao.modules.pauta.actions.obtencao.porid.services.core.impl;

import br.com.votacao.modules.pauta.actions.obtencao.porid.models.PautaResponse;
import br.com.votacao.modules.pauta.actions.obtencao.porid.models.mock.PautaResponseMock;
import br.com.votacao.modules.pauta.actions.obtencao.porid.services.core.exceptions.PautaNaoEncontradaPorIdException;
import br.com.votacao.modules.pauta.actions.obtencao.porid.services.mapper.ObtencaoPautaPorIdMapperService;
import br.com.votacao.modules.pauta.entity.mock.PautaEntityMock;
import br.com.votacao.modules.pauta.models.entity.PautaEntity;
import br.com.votacao.modules.pauta.repository.PautaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("ServiceImpl: ObtencaoPautaPorId")
class ObtencaoPautaPorIdServiceImplTest {

    @InjectMocks
    ObtencaoPautaPorIdServiceImpl obtencaoPautaPorIdServiceImpl;

    @Mock
    ObtencaoPautaPorIdMapperService obtencaoPautaPorIdMapperService;

    @Mock
    PautaRepository pautaRepository;

    @Test
    @DisplayName("Deve testar obtenção de pautas por id")
    void deveTestarObtencaoDePautasPorId() {

        PautaEntity pautaEntity = PautaEntityMock.builder().build();
        PautaResponse pautaResponse = PautaResponseMock.builder().build();

        when(pautaRepository.findById(any())).thenReturn(Optional.of(pautaEntity));
        when(obtencaoPautaPorIdMapperService.realizaCriacaoDeObjetoPautaResponse(any())).thenReturn(pautaResponse);

        PautaResponse respostaServico =
                obtencaoPautaPorIdServiceImpl.realizaObtencaoDePautaPorId(
                        UUID.fromString("f2ac6801-6cad-4408-b002-31d00314f493")
                );

        Assertions.assertEquals(
                "PautaResponse[titulo=Legalização do @Data, descricao=Nessa pauta votaremos se o @Data deverá " +
                        "ou não ser legalizado nesta API, status=Encerrada, quantidadeVotosSim=1, quantidadesVotosNao=0, " +
                        "dataHoraCriacao=2024-11-14T09:13, dataHoraExpiracao=2024-11-14T09:13, " +
                        "votos=[VotoPautaResponse[tipoVoto=Sim, dataHoraVoto=2024-11-13T23:53, " +
                        "nomeAssociado=Gabriel Lagrota]]]",
                respostaServico.toString()
        );
    }

    @Test
    @DisplayName("Deve testar obtenção de pautas por id com exception")
    void deveTestarObtencaoDePautasPorIdComException() {

        when(pautaRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows((PautaNaoEncontradaPorIdException.class), () ->
                obtencaoPautaPorIdServiceImpl.realizaObtencaoDePautaPorId(
                        UUID.fromString("f2ac6801-6cad-4408-b002-31d00314f493")
                )
        );
    }
}
