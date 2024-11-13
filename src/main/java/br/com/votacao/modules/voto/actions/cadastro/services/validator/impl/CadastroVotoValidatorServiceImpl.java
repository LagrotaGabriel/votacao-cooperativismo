package br.com.votacao.modules.voto.actions.cadastro.services.validator.impl;

import br.com.votacao.modules.pauta.entity.PautaEntity;
import br.com.votacao.modules.voto.actions.cadastro.services.validator.CadastroVotoValidatorService;
import br.com.votacao.modules.voto.actions.cadastro.services.validator.exceptions.PautaExpiradaException;
import br.com.votacao.modules.voto.actions.cadastro.services.validator.exceptions.VotoDuplicadoDoAssociadoNaPautaException;
import br.com.votacao.modules.voto.entity.VotoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * CadastroVotoValidatorServiceImpl
 * Service responsável por realizar as validações relacionadas ao contexto de cadastro de novo Voto
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 16:19
 */
@Slf4j
@Service
public class CadastroVotoValidatorServiceImpl implements CadastroVotoValidatorService {

    @Override
    public void realizaValidacoesDoCadastroDeVoto(PautaEntity pauta,
                                                  UUID idAssociado) {

        log.debug("Metodo responsavel por orquestrar as validacoes para cadastro de novo voto acessado");
        log.trace("pauta: {}", pauta);
        log.trace("idAssociado: {}", idAssociado);

        log.debug("Iniciando acesso a validacao se associado ja votou na pauta selecionada...");
        validaSeAssociadoJaVotouNaPautaSelecionada(pauta.getVotos(), idAssociado);
        log.debug("Acesso a validacao se associado ja votou na pauta selecionada finalizado");

        log.debug("Iniciando acesso a validacao se pauta ja expirou...");
        validaSePautaJaExpirou(pauta.getDataHoraExpiracao());
        log.debug("Acesso a validacao se pauta ja expirou finalizado");

        log.debug("Todas as validacoes do cadastro de novo voto finalizadas");
    }

    @Override
    public void validaSeAssociadoJaVotouNaPautaSelecionada(List<VotoEntity> votosRealizadosNaPauta,
                                                           UUID idAssociado) {

        log.debug("Metodo de validacao responsavel por validar se associado ja votou na pauta selecionada acessado");
        log.trace("votosRealizadosNaPauta: {}", votosRealizadosNaPauta);
        log.trace("idAssociado recebido: {}", idAssociado);

        for (VotoEntity voto : votosRealizadosNaPauta) {
            if (voto.getAssociado().getId() == idAssociado) {
                log.warn("Esse associado ja realizou uma votacao nessa pauta");
                throw new VotoDuplicadoDoAssociadoNaPautaException("Um associado não pode votar mais de uma vez em uma pauta");
            }
        }

        log.debug("Metodo de validacao responsavel por validar se associado ja votou na pauta selecionada finalizado");
    }

    @Override
    public void validaSePautaJaExpirou(LocalDateTime dataHoraExpiracaoPauta) {

        log.debug("Metodo de validacao responsavel por realizar a validacao se pauta ja expirou acessado");
        log.trace("dataHoraExpiracaoPauta: {}", dataHoraExpiracaoPauta);

        LocalDateTime dataHoraAtual = LocalDateTime.now();

        if (dataHoraExpiracaoPauta.isBefore(dataHoraAtual)) {
            log.warn("Esta pauta esta expirada");
            throw new PautaExpiradaException("Não é possível realizar a votação em uma pauta que já expirou");
        }

        log.debug("Metodo de validacao responsavel por realizar a validacao se pauta ja expirou finalizado");
    }
}
