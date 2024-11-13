package br.com.votacao.modules.voto.actions.cadastro.services.validator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * PautaExpiradaException
 * Exception que deverá ser lançada caso um associado tente votar em uma pauta que já está expirada
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 16:53
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PautaExpiradaException extends RuntimeException {

    public PautaExpiradaException(String message) {
        super(message);
    }
}
