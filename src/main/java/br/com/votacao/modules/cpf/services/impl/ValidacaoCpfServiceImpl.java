package br.com.votacao.modules.cpf.services.impl;

import br.com.votacao.modules.cpf.models.request.CpfRequest;
import br.com.votacao.modules.cpf.models.response.CpfResponse;
import br.com.votacao.modules.cpf.proxy.ValidacaoCpfProxy;
import br.com.votacao.modules.cpf.proxy.models.enums.StatusValidacaoCpfEnum;
import br.com.votacao.modules.cpf.proxy.models.response.ValidacaoCpfProxyResponse;
import br.com.votacao.modules.cpf.services.ValidacaoCpfService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * ValidacaoCpfServiceImpl
 * Classe responsável por realizar a integração com a integradora fake para validação do cpf informado pelo usuário
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 14/11/2024 - 11:00
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ValidacaoCpfServiceImpl implements ValidacaoCpfService {

    private final ValidacaoCpfProxy validacaoCpfProxy;

    @Override
    public CpfResponse realizaValidacaoDeCpf(CpfRequest cpfRequest) {

        log.debug("Metodo responsavel por realizar validacao de CPF acessado");
        log.trace("cpfRequest: {}", cpfRequest);

        try {

            log.debug("Iniciando integracao com integradora mock para validacao de CPF...");
            ResponseEntity<ValidacaoCpfProxyResponse> responseEntity =
                    validacaoCpfProxy.realizaValidacaoDeCpfNaIntegradora(
                            cpfRequest.cpf()
                    );
            log.debug("A integracao com a integradora mock foi realizada com sucesso");
            log.trace("responseEntity: {}", responseEntity);

            if (responseEntity.getBody() == null) {
                log.error("Nenhum body foi retornado pela integradora durante a validacao de CPF");
                throw new InternalError("Nenhum body foi retornado pela integradora durante a validacao de CPF");
            }

            return new CpfResponse(
                    responseEntity.getBody().status(), LocalDateTime.now()
            );

        } catch (Exception e) {

            log.warn("Ocorreu um erro esperado, pois a integradora nao existe");

            LocalDateTime dataHoraAtual = LocalDateTime.now();
            CpfResponse cpfResponse;

            if ((dataHoraAtual.getSecond() % 2) == 0) {
                cpfResponse = new CpfResponse(StatusValidacaoCpfEnum.ABLE_TO_VOTE, dataHoraAtual);
            }
            else {
                cpfResponse = new CpfResponse(StatusValidacaoCpfEnum.UNABLE_TO_VOTE, dataHoraAtual);
            }

            log.info("Execucao do metodo de validacao de CPF finalizada com sucesso");
            return cpfResponse;
        }
    }
}
