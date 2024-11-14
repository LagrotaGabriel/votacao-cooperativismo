package br.com.votacao.modules.voto.actions.cadastro.services.core.impl;

import br.com.votacao.modules.associado.entity.AssociadoEntity;
import br.com.votacao.modules.associado.entity.mock.AssociadoEntityMock;
import br.com.votacao.modules.associado.repository.AssociadoRepository;
import br.com.votacao.modules.pauta.models.entity.PautaEntity;
import br.com.votacao.modules.pauta.entity.mock.PautaEntityMock;
import br.com.votacao.modules.pauta.repository.PautaRepository;
import br.com.votacao.modules.voto.actions.cadastro.dto.request.CadastroVotoRequest;
import br.com.votacao.modules.voto.actions.cadastro.dto.request.mock.CadastroVotoRequestMock;
import br.com.votacao.modules.voto.actions.cadastro.dto.response.CadastroVotoResponse;
import br.com.votacao.modules.voto.actions.cadastro.dto.response.mock.CadastroVotoResponseMock;
import br.com.votacao.modules.voto.actions.cadastro.services.core.exceptions.AssociadoNaoEncontradoException;
import br.com.votacao.modules.voto.actions.cadastro.services.core.exceptions.PautaNaoEncontradaException;
import br.com.votacao.modules.voto.actions.cadastro.services.mapper.CadastroVotoMapperService;
import br.com.votacao.modules.voto.actions.cadastro.services.validator.CadastroVotoValidatorService;
import br.com.votacao.modules.voto.entity.VotoEntity;
import br.com.votacao.modules.voto.entity.mock.VotoEntityMock;
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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("ServiceImpl: CadastroVoto")
class CadastroVotoServiceImplTest {

    @InjectMocks
    CadastroVotoServiceImpl cadastroVotoServiceImpl;

    @Mock
    CadastroVotoValidatorService validatorService;

    @Mock
    CadastroVotoMapperService mapperService;

    @Mock
    PautaRepository pautaRepository;

    @Mock
    AssociadoRepository associadoRepository;

    @Test
    @DisplayName("Deve testar cadastro de voto com sucesso")
    void deveTestarCadastroDeVotoComSucesso() {

        UUID idPautaMock = UUID.fromString("8429be2a-fd36-4d30-ac69-d79661e42eb4");
        CadastroVotoRequest cadastroVotoRequestMock = CadastroVotoRequestMock.builder().build();

        PautaEntity pautaEntityMock = PautaEntityMock.builder().build();
        AssociadoEntity associadoEntityMock = AssociadoEntityMock.builder().build();
        VotoEntity votoEntityMock = VotoEntityMock.builder().build();
        CadastroVotoResponse cadastroVotoResponseMock = CadastroVotoResponseMock.builder().build();

        when(pautaRepository.findById(any())).thenReturn(Optional.of(pautaEntityMock));
        when(associadoRepository.findById(any())).thenReturn(Optional.of(associadoEntityMock));
        doNothing().when(validatorService).realizaValidacoesDoCadastroDeVoto(any(), any());
        when(mapperService.geraVotoEntityAPartirDeCadastroVotoRequest(any(), any())).thenReturn(votoEntityMock);
        when(pautaRepository.save(any())).thenReturn(pautaEntityMock);
        when(mapperService.geraVotoResponseAPartirDeVotoEntity(any(), any())).thenReturn(cadastroVotoResponseMock);

        CadastroVotoResponse respostaServico =
                cadastroVotoServiceImpl.realizaCadastroDeNovoVoto(
                        idPautaMock,
                        cadastroVotoRequestMock
                );

        Assertions.assertEquals(
                "CadastroVotoResponse[idVoto=74bcd515-655c-4def-8dc8-3329ccbdf62e, quantidadeDeVotosComputados=5]",
                respostaServico.toString()
        );
    }

    @Test
    @DisplayName("Deve testar cadastro de voto com exception de pauta nao encontrada")
    void deveTestarCadastroDeVotoComExceptionDePautaNaoEncontrada() {

        UUID idPautaMock = UUID.fromString("8429be2a-fd36-4d30-ac69-d79661e42eb4");
        CadastroVotoRequest cadastroVotoRequestMock = CadastroVotoRequestMock.builder().build();

        when(pautaRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows((PautaNaoEncontradaException.class), () ->
                cadastroVotoServiceImpl.realizaCadastroDeNovoVoto(
                        idPautaMock,
                        cadastroVotoRequestMock
                )
        );
    }

    @Test
    @DisplayName("Deve testar cadastro de voto com exception de associado nao encontrado")
    void deveTestarCadastroDeVotoComExceptionDeAssociadoNaoEncontrado() {

        UUID idPautaMock = UUID.fromString("8429be2a-fd36-4d30-ac69-d79661e42eb4");
        CadastroVotoRequest cadastroVotoRequestMock = CadastroVotoRequestMock.builder().build();

        PautaEntity pautaEntityMock = PautaEntityMock.builder().build();

        when(pautaRepository.findById(any())).thenReturn(Optional.of(pautaEntityMock));
        when(associadoRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows((AssociadoNaoEncontradoException.class), () ->
                cadastroVotoServiceImpl.realizaCadastroDeNovoVoto(
                        idPautaMock,
                        cadastroVotoRequestMock
                )
        );
    }

}
