package br.com.votacao.modules.voto.actions.cadastro.controller.impl;

import br.com.votacao.modules.voto.actions.cadastro.controller.CadastroVotoSwaggerController;
import br.com.votacao.modules.voto.actions.cadastro.dto.request.CadastroVotoRequest;
import br.com.votacao.modules.voto.actions.cadastro.dto.response.CadastroVotoResponse;
import br.com.votacao.modules.voto.actions.cadastro.services.core.CadastroVotoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * CadastroVotoController
 * Classe responsável por disponibilizar endpoints inclusos no contexto do cadastro de um voto em uma pauta
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 16:57
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/srv-votacao/v1/voto")
public class CadastroVotoController implements CadastroVotoSwaggerController {

    private final CadastroVotoService cadastroVotoService;

    @Override
    @PostMapping("/{idPauta}")
    public ResponseEntity<CadastroVotoResponse> criaNovoVoto(@PathVariable("idPauta") UUID idPauta,
                                                             @Valid @RequestBody CadastroVotoRequest cadastroVotoRequest) {

        log.info("Endpoint de cadastro de novo voto em uma pauta acessado");
        log.trace("idPauta: {}", idPauta);
        log.trace("cadastroVotoRequest: {}", cadastroVotoRequest);

        log.debug("Iniciando acesso ao service de cadastro de voto...");
        return ResponseEntity.status(HttpStatus.CREATED).body(
                cadastroVotoService.realizaCadastroDeNovoVoto(
                        idPauta,
                        cadastroVotoRequest
                )
        );
    }
}
