package br.com.votacao.modules.associado.actions.cadastro.services.validator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * CpfDoAssociadoJaExisteException
 * Exception que deverá ser lançada caso o usuário tente cadastrar um associado com um CPF que já existe no
 * cadastro de outro associado
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 10:11
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CpfDoAssociadoJaExisteException extends RuntimeException {

    public CpfDoAssociadoJaExisteException(String message) {
        super(message);
    }
}
