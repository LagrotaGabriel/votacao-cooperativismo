package br.com.votacao.modules.voto.actions.cadastro.services.validator;

import br.com.votacao.modules.pauta.models.entity.PautaEntity;
import br.com.votacao.modules.voto.entity.VotoEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface CadastroVotoValidatorService {

    void realizaValidacoesDoCadastroDeVoto(
      PautaEntity pauta,
      UUID idAssociado
    );

    void validaSeAssociadoJaVotouNaPautaSelecionada(
            List<VotoEntity> votosRealizadosNaPauta,
            UUID idAssociado
    );

    void validaSePautaJaExpirou(
            LocalDateTime dataHoraExpiracaoPauta
    );
}
