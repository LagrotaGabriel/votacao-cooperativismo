package br.com.votacao.modules.voto.actions.cadastro.services.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * PautaNaoEncontradaException
 * Exception que deverá ser lançada caso uma pauta não seja encontrada durante o processo de cadastro de um novo voto
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 17:16
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PautaNaoEncontradaException extends RuntimeException {

    public PautaNaoEncontradaException(String message) {
        super(message);
    }
}
