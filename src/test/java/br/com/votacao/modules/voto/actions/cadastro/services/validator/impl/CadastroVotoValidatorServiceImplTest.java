package br.com.votacao.modules.voto.actions.cadastro.services.validator.impl;

import br.com.votacao.modules.pauta.models.entity.PautaEntity;
import br.com.votacao.modules.pauta.entity.mock.PautaEntityMock;
import br.com.votacao.modules.voto.actions.cadastro.services.validator.exceptions.PautaExpiradaException;
import br.com.votacao.modules.voto.actions.cadastro.services.validator.exceptions.VotoDuplicadoDoAssociadoNaPautaException;
import br.com.votacao.modules.voto.entity.VotoEntity;
import br.com.votacao.modules.voto.entity.mock.VotoEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("ValidatorService: CadastroVoto")
class CadastroVotoValidatorServiceImplTest {

    @InjectMocks
    CadastroVotoValidatorServiceImpl cadastroVotoValidatorServiceImpl;

    @Test
    @DisplayName("Deve testar validacoes do cadastro de voto")
    void deveTestarValidacoesDoCadastroDeVoto() {

        PautaEntity pauta = PautaEntityMock.builder().ComDataDeExpiracaoNoFuturo().build();

        UUID idAssociado = UUID.fromString("8429be2a-fd36-4d30-ac69-d79661e42eb4");

        Assertions.assertDoesNotThrow(() ->
                cadastroVotoValidatorServiceImpl.realizaValidacoesDoCadastroDeVoto(
                        pauta,
                        idAssociado
                )
        );
    }

    @Test
    @DisplayName("Deve testar se associado ja votou na pauta selecionada com sucesso")
    void deveTestarSeAssociadoJaVotouNaPautaSelecionadaComSucesso() {

        List<VotoEntity> votoEntityList = new ArrayList<>();
        VotoEntity votoEntity = VotoEntityMock.builder().build();

        votoEntityList.add(votoEntity);

        Assertions.assertDoesNotThrow(() ->
                cadastroVotoValidatorServiceImpl.validaSeAssociadoJaVotouNaPautaSelecionada(
                        votoEntityList,
                        UUID.fromString("8429be2a-fd36-4d30-ac69-d79661e42eb4")
                )
        );
    }

    @Test
    @DisplayName("Deve testar se associado ja votou na pauta selecionada com exception")
    void deveTestarSeAssociadoJaVotouNaPautaSelecionadaComException() {

        List<VotoEntity> votoEntityList = new ArrayList<>();
        VotoEntity votoEntity = VotoEntityMock.builder().build();

        votoEntityList.add(votoEntity);

        Assertions.assertThrows((VotoDuplicadoDoAssociadoNaPautaException.class), () ->
                cadastroVotoValidatorServiceImpl.validaSeAssociadoJaVotouNaPautaSelecionada(
                        votoEntityList,
                        votoEntity.getAssociado().getId()
                )
        );
    }

    @Test
    @DisplayName("Deve testar metodo de validacao de votacao em pauta expirada com sucesso")
    void deveTestarMetodoDeValidacaoDeVotacaoEmPautaExpiradaComSucesso() {

        LocalDateTime dataDaExpiracaoDaPauta = LocalDateTime.now().plusMinutes(10L);

        Assertions.assertDoesNotThrow(() ->
                cadastroVotoValidatorServiceImpl.validaSePautaJaExpirou(
                        dataDaExpiracaoDaPauta
                )
        );
    }

    @Test
    @DisplayName("Deve testar metodo de validacao de votacao em pauta expirada com exception")
    void deveTestarMetodoDeValidacaoDeVotacaoEmPautaExpiradaComException() {

        LocalDateTime dataDaExpiracaoDaPauta = LocalDateTime.of(2023, 5, 13, 12, 0);

        Assertions.assertThrows((PautaExpiradaException.class), () ->
                cadastroVotoValidatorServiceImpl.validaSePautaJaExpirou(
                        dataDaExpiracaoDaPauta
                )
        );
    }
}
