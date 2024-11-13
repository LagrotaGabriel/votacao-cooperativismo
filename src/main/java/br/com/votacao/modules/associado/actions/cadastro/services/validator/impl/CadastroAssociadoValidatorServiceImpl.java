package br.com.votacao.modules.associado.actions.cadastro.services.validator.impl;

import br.com.votacao.modules.associado.actions.cadastro.services.validator.CadastroAssociadoValidatorService;
import br.com.votacao.modules.associado.actions.cadastro.services.validator.exceptions.CpfDoAssociadoJaExisteException;
import br.com.votacao.modules.associado.repository.AssociadoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * CadastroAssociadoValidatorServiceImpl
 * Service responsável por realizar as validações relacionadas ao contexto de cadastro de novo associado
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 09:59
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CadastroAssociadoValidatorServiceImpl implements CadastroAssociadoValidatorService {

    private final AssociadoRepository associadoRepository;

    @Override
    public void realizaValidacaoSeJaExisteUmAssociadoCadastradoComCpfInformado(String cpf) {

        log.debug("Metodo responsavel por realizar validacao se ja existe um associado cadastrado com o CPF informado acessado");
        log.trace("cpf: {}", cpf);

        log.debug("Iniciando acesso ao repositorio de verificacao se existe algum cliente cadastrado com o CPF informado...");
        Boolean existeClienteCadastradoComCpfInformado = associadoRepository.verificaSeJaExisteUmAssociadoCadastradoComCpfInformado(cpf);
        log.debug("Acesso ao repositorio de verificacao se existe algum cliente cadastrado com o CPF informado finalizado");
        log.trace("existeClienteCadastradoComCpfInformado: {}", existeClienteCadastradoComCpfInformado);

        if (Boolean.TRUE.equals(existeClienteCadastradoComCpfInformado)) {
            log.warn("Ja existe um cliente cadastrado com o CPF informado: {}", cpf);
            throw new CpfDoAssociadoJaExisteException("Já existe um associado cadastrado com o CPF informado. Insira outro CPF e tente novamente");
        }

        log.debug("Metodo responsavel por realizar validacao se ja existe um associado cadastrado com o CPF informado finalizado");
    }
}
