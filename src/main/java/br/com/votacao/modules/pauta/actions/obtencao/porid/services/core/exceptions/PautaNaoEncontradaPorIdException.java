package br.com.votacao.modules.pauta.actions.obtencao.porid.services.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * PautaNaoEncontradaPorIdException
 * Exception que deverá ser lançada caso durante a busca de uma pauta por id nenhum resultado seja obtido
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 14/11/2024 - 08:31
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PautaNaoEncontradaPorIdException extends RuntimeException {

    public PautaNaoEncontradaPorIdException(String message) {
        super(message);
    }
}
