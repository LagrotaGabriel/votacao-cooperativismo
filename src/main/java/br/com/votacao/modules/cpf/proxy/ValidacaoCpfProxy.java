package br.com.votacao.modules.cpf.proxy;

import br.com.votacao.modules.cpf.proxy.models.response.ValidacaoCpfProxyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "VALIDACAO-CPF-INTEGRADORA-MOCK", url = "https://www.integradoramock.com.br/valida-cpf")
public interface ValidacaoCpfProxy {

    @GetMapping("/{cpf}")
    ResponseEntity<ValidacaoCpfProxyResponse> realizaValidacaoDeCpfNaIntegradora(
            @PathVariable("cpf") String cpf
    );
}
