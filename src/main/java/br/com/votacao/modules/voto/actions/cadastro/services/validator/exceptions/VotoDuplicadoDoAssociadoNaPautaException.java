package br.com.votacao.modules.voto.actions.cadastro.services.validator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * VotoDuplicadoDoAssociadoNaPautaException
 * Exception que deverá ser lançada caso um associado tente realizar mais de um voto em uma determinada pauta
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 16:47
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VotoDuplicadoDoAssociadoNaPautaException extends RuntimeException {

    public VotoDuplicadoDoAssociadoNaPautaException(String message) {
        super(message);
    }
}
