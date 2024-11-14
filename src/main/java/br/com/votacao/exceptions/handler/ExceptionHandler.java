package br.com.votacao.exceptions.handler;

import br.com.votacao.exceptions.models.StandartError;
import br.com.votacao.modules.associado.actions.cadastro.services.validator.exceptions.CpfDoAssociadoJaExisteException;
import br.com.votacao.modules.pauta.actions.obtencao.porid.services.core.exceptions.PautaNaoEncontradaPorIdException;
import br.com.votacao.modules.voto.actions.cadastro.services.core.exceptions.AssociadoNaoEncontradoException;
import br.com.votacao.modules.voto.actions.cadastro.services.core.exceptions.PautaNaoEncontradaException;
import br.com.votacao.modules.voto.actions.cadastro.services.validator.exceptions.PautaExpiradaException;
import br.com.votacao.modules.voto.actions.cadastro.services.validator.exceptions.VotoDuplicadoDoAssociadoNaPautaException;
import jakarta.annotation.Nonnull;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(CpfDoAssociadoJaExisteException.class)
    public ResponseEntity<StandartError> cpfDoAssociadoJaExisteExceptionHandler(HttpServletRequest req,
                                                                                CpfDoAssociadoJaExisteException cpfDoAssociadoJaExisteException) {

        StandartError standartError = StandartError.builder()
                .localDateTime(LocalDateTime.now().toString())
                .status(400)
                .error(cpfDoAssociadoJaExisteException.getMessage())
                .path(req.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standartError);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PautaExpiradaException.class)
    public ResponseEntity<StandartError> pautaExpiradaExceptionHandler(HttpServletRequest req,
                                                                       PautaExpiradaException pautaExpiradaException) {

        StandartError standartError = StandartError.builder()
                .localDateTime(LocalDateTime.now().toString())
                .status(400)
                .error(pautaExpiradaException.getMessage())
                .path(req.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standartError);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PautaNaoEncontradaException.class)
    public ResponseEntity<StandartError> pautaNaoEncontradaExceptionHandler(HttpServletRequest req,
                                                                            PautaNaoEncontradaException pautaNaoEncontradaException) {

        StandartError standartError = StandartError.builder()
                .localDateTime(LocalDateTime.now().toString())
                .status(404)
                .error(pautaNaoEncontradaException.getMessage())
                .path(req.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standartError);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(AssociadoNaoEncontradoException.class)
    public ResponseEntity<StandartError> pautaNaoEncontradaExceptionHandler(HttpServletRequest req,
                                                                            AssociadoNaoEncontradoException associadoNaoEncontradoException) {

        StandartError standartError = StandartError.builder()
                .localDateTime(LocalDateTime.now().toString())
                .status(404)
                .error(associadoNaoEncontradoException.getMessage())
                .path(req.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standartError);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(VotoDuplicadoDoAssociadoNaPautaException.class)
    public ResponseEntity<StandartError> votoDuplicadoDoAssociadoNaPautaExceptionHandler(HttpServletRequest req,
                                                                                         VotoDuplicadoDoAssociadoNaPautaException votoDuplicadoDoAssociadoNaPautaException) {

        StandartError standartError = StandartError.builder()
                .localDateTime(LocalDateTime.now().toString())
                .status(400)
                .error(votoDuplicadoDoAssociadoNaPautaException.getMessage())
                .path(req.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standartError);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PautaNaoEncontradaPorIdException.class)
    public ResponseEntity<StandartError> pautaNaoEncontradaPorIdExceptionHandler(HttpServletRequest req,
                                                                                 PautaNaoEncontradaPorIdException pautaNaoEncontradaPorIdException) {

        StandartError standartError = StandartError.builder()
                .localDateTime(LocalDateTime.now().toString())
                .status(404)
                .error(pautaNaoEncontradaPorIdException.getMessage())
                .path(req.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standartError);
    }

    @Nonnull
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            String fieldName = violation.getPropertyPath().toString();
            String errorMessage = violation.getMessage();
            errors.put(fieldName, errorMessage);
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
