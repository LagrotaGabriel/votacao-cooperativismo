package br.com.votacao.modules.voto.actions.cadastro.services.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * AssociadoNaoEncontradoException
 * Exception que deverá ser lançada caso um associado não seja encontrado durante o processo de cadastro de um novo voto
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 17:36
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AssociadoNaoEncontradoException extends RuntimeException {

    public AssociadoNaoEncontradoException(String message) {
        super(message);
    }
}
