package br.com.votacao.modules.cpf.controller.impl;

import br.com.votacao.modules.cpf.controller.ValidacaoCpfSwaggerController;
import br.com.votacao.modules.cpf.models.CpfRequest;
import br.com.votacao.modules.cpf.models.CpfResponse;
import br.com.votacao.modules.cpf.proxy.models.enums.StatusValidacaoCpfEnum;
import br.com.votacao.modules.cpf.services.ValidacaoCpfService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ValidacaoCpfSwaggerController
 * Classe responsável por disponibilizar endpoints inclusos no contexto da validação de um CPF
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 14/11/2024 - 11:16
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/srv-votacao/v1/cpf")
public class ValidacaoCpfController implements ValidacaoCpfSwaggerController {

    private final ValidacaoCpfService validacaoCpfService;

    @Override
    @PostMapping("/validacao")
    public ResponseEntity<CpfResponse> validaCpf(@Valid @RequestBody CpfRequest cpfRequest) {

        log.info("Endpoint de validacao de CPF acessado");
        log.trace("cpfRequest: {}", cpfRequest);

        CpfResponse cpfResponse =
                validacaoCpfService.realizaValidacaoDeCpf(
                        cpfRequest
                );

        HttpStatus statusRespostaChamada =
                (StatusValidacaoCpfEnum.ABLE_TO_VOTE.equals(cpfResponse.status()))
                        ? HttpStatus.OK
                        : HttpStatus.NOT_FOUND;

        return ResponseEntity.status(statusRespostaChamada).body(cpfResponse);
    }
}
