package br.com.votacao.modules.pauta.actions.obtencao.paginada.controller.impl;

import br.com.votacao.modules.pauta.actions.obtencao.paginada.controller.ObtencaoPaginadaPautaSwaggerController;
import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.PautaPageResponse;
import br.com.votacao.modules.pauta.actions.obtencao.paginada.services.core.ObtencaoPaginadaPautaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * implObtencaoPaginadaPautaController
 * Classe responsável por disponibilizar endpoints inclusos no contexto da obtenção paginada de uma nova Pauta
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 23:27
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/srv-votacao/v1/pauta")
public class ObtencaoPaginadaPautaController implements ObtencaoPaginadaPautaSwaggerController {

    private final ObtencaoPaginadaPautaService obtencaoPaginadaPautaService;

    @Override
    @GetMapping
    public ResponseEntity<PautaPageResponse> realizaObtencaoPaginadaPorPautas(@PageableDefault Pageable pageable) {

        log.info("Endpoint de obtencao paginada por pautas acessado");
        log.trace("pageable: {}", pageable);

        log.debug("Iniciando acesso ao service de obtencao paginada de pautas...");
        return ResponseEntity.status(HttpStatus.OK).body(
                obtencaoPaginadaPautaService.realizaObtencaoPaginadaPorPautas(
                        pageable
                )
        );
    }
}
