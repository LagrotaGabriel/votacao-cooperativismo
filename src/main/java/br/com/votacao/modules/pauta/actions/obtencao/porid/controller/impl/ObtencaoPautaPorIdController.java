package br.com.votacao.modules.pauta.actions.obtencao.porid.controller.impl;

import br.com.votacao.modules.pauta.actions.obtencao.porid.controller.ObtencaoPautaPorIdSwaggerController;
import br.com.votacao.modules.pauta.actions.obtencao.porid.models.PautaResponse;
import br.com.votacao.modules.pauta.actions.obtencao.porid.services.core.ObtencaoPautaPorIdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * ObtencaoPautaPorIdController
 * Classe responsável por disponibilizar endpoints inclusos no contexto da obtenção de pauta por id
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 14/11/2024 - 08:35
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/srv-votacao/v1/pauta")
public class ObtencaoPautaPorIdController implements ObtencaoPautaPorIdSwaggerController {

    private final ObtencaoPautaPorIdService obtencaoPautaPorIdService;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PautaResponse> realizaObtencaoDePautaPorId(@PathVariable("id") UUID id) {

        log.info("Endpoint de obtencao de pauta por id acessado");
        log.trace("id: {}", id);

        log.debug("Iniciando acesso ao service de obtencao de pauta por id...");
        return ResponseEntity.status(HttpStatus.OK).body(
                obtencaoPautaPorIdService.realizaObtencaoDePautaPorId(
                        id
                )
        );
    }
}
