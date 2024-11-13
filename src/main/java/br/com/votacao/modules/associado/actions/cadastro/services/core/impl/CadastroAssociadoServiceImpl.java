package br.com.votacao.modules.associado.actions.cadastro.services.core.impl;

import br.com.votacao.modules.associado.actions.cadastro.dto.request.CadastroAssociadoRequest;
import br.com.votacao.modules.associado.actions.cadastro.dto.response.CadastroAssociadoResponse;
import br.com.votacao.modules.associado.actions.cadastro.services.core.CadastroAssociadoService;
import br.com.votacao.modules.associado.actions.cadastro.services.mapper.CadastroAssociadoMapperService;
import br.com.votacao.modules.associado.actions.cadastro.services.validator.CadastroAssociadoValidatorService;
import br.com.votacao.modules.associado.entity.AssociadoEntity;
import br.com.votacao.modules.associado.repository.AssociadoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * CadastroAssociadoServiceImpl
 * Service responsável por realizar o cadastro de um novo associado
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 09:58
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CadastroAssociadoServiceImpl implements CadastroAssociadoService {

    private final CadastroAssociadoValidatorService validatorService;
    private final CadastroAssociadoMapperService mapperService;
    private final AssociadoRepository repository;

    @Override
    public CadastroAssociadoResponse realizaCadastroDeNovoAssociado(CadastroAssociadoRequest cadastroAssociadoRequest) {

        log.debug("Metodo responsavel por realizar o cadastro de um novo associado acessado");
        log.trace("cadastroAssociadoRequest: {}", cadastroAssociadoRequest);

        log.debug("Iniciando acesso ao metodo responsavel por realizar a validacao do CPF do associado...");
        validatorService.realizaValidacaoSeJaExisteUmAssociadoCadastradoComCpfInformado(
                cadastroAssociadoRequest.cpf()
        );
        log.debug("Acesso ao metodo responsavel por realizar a validacao do CPF do associado finalizado");

        log.debug("Iniciando acesso ao metodo responsavel por realizar a criacao de AssociadoEntity a partir de CadastroAssociadoRequest...");
        AssociadoEntity associadoEntity =
                mapperService.geraAssociadoEntityAPartirDeCadastroAssociadoRequest(
                        cadastroAssociadoRequest
                );
        log.debug("Acesso ao metodo responsavel por realizar a criacao de AssociadoEntity a partir de CadastroAssociadoRequest finalizado");
        log.trace("associadoEntity: {}", associadoEntity);

        log.debug("Iniciando persistencia do associado gerado no banco de dados...");
        AssociadoEntity associadoPersistido = repository.save(associadoEntity);
        log.debug("Persistencia do associado gerado no banco de dados realizada com sucesso");
        log.trace("associadoPersistido: {}", associadoPersistido);

        log.debug("Iniciando acesso ao metodo responsavel por realizar a criacao de CadastroAssociadoResponse a partir de AssociadoEntity...");
        CadastroAssociadoResponse cadastroAssociadoResponse =
                mapperService.geraAssociadoResponseAPartirDeAssociadoEntity(
                        associadoPersistido
                );
        log.debug("Acesso ao metodo responsavel por realizar a criacao de CadastroAssociadoResponse a partir de AssociadoEntity finalizado");
        log.trace("cadastroAssociadoResponse: {}", cadastroAssociadoResponse);

        log.info("Service de cadastro de associado finalizado com sucesso");
        log.debug("Retornando objeto de resposta gerado...");
        return cadastroAssociadoResponse;
    }
}
