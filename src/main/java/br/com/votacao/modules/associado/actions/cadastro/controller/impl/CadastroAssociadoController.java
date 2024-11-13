package br.com.votacao.modules.associado.actions.cadastro.controller.impl;

import br.com.votacao.modules.associado.actions.cadastro.controller.CadastroAssociadoSwaggerController;
import br.com.votacao.modules.associado.actions.cadastro.dto.request.CadastroAssociadoRequest;
import br.com.votacao.modules.associado.actions.cadastro.dto.response.CadastroAssociadoResponse;
import br.com.votacao.modules.associado.actions.cadastro.services.core.CadastroAssociadoService;
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
 * CriacaoAssociadoController
 * Classe responsável por disponibilizar endpoints inclusos no contexto do cadastro de um novo Associado
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 09:50
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/srv-votacao/v1/associado")
public class CadastroAssociadoController implements CadastroAssociadoSwaggerController {

    private final CadastroAssociadoService cadastroAssociadoService;

    @Override
    @PostMapping
    public ResponseEntity<CadastroAssociadoResponse> criaNovoAssociado(@Valid @RequestBody CadastroAssociadoRequest cadastroAssociadoRequest) {

        log.info("Endpoint de cadastro de novo associado acessado");
        log.trace("cadastroAssociadoRequest: {}", cadastroAssociadoRequest);

        log.debug("Iniciando acesso ao service de cadastro de associados...");
        return ResponseEntity.status(HttpStatus.CREATED).body(
                cadastroAssociadoService.realizaCadastroDeNovoAssociado(
                        cadastroAssociadoRequest
                )
        );
    }
}
