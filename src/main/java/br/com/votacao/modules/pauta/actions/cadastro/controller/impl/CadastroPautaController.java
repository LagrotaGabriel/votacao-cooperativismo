package br.com.votacao.modules.pauta.actions.cadastro.controller.impl;

import br.com.votacao.modules.pauta.actions.cadastro.controller.CadastroPautaSwaggerController;
import br.com.votacao.modules.pauta.actions.cadastro.dto.request.CadastroPautaRequest;
import br.com.votacao.modules.pauta.actions.cadastro.dto.response.CadastroPautaResponse;
import br.com.votacao.modules.pauta.actions.cadastro.services.core.CadastroPautaService;
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
 * CadastroPautaController
 * Classe responsável por disponibilizar endpoints inclusos no contexto do cadastro de uma nova Pauta
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 11:43
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/srv-votacao/v1/pauta")
public class CadastroPautaController implements CadastroPautaSwaggerController {

    private final CadastroPautaService cadastroPautaService;

    @Override
    @PostMapping
    public ResponseEntity<CadastroPautaResponse> criaNovaPauta(@Valid @RequestBody CadastroPautaRequest cadastroPautaRequest) {

        log.info("Endpoint de cadastro de nova pauta acessado");
        log.trace("cadastroPautaRequest: {}", cadastroPautaRequest);

        log.debug("Iniciando acesso ao service de cadastro de pautas...");
        return ResponseEntity.status(HttpStatus.CREATED).body(
                cadastroPautaService.realizaCadastroDeNovaPauta(
                        cadastroPautaRequest
                )
        );
    }
}
