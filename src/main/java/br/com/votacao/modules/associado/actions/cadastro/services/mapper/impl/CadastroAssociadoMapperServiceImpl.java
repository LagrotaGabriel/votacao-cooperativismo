package br.com.votacao.modules.associado.actions.cadastro.services.mapper.impl;

import br.com.votacao.modules.associado.actions.cadastro.dto.request.CadastroAssociadoRequest;
import br.com.votacao.modules.associado.actions.cadastro.dto.response.CadastroAssociadoResponse;
import br.com.votacao.modules.associado.actions.cadastro.services.mapper.CadastroAssociadoMapperService;
import br.com.votacao.modules.associado.entity.AssociadoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * CadastroAssociadoMapperServiceImpl
 * Classe responsável por realizar o mapeamento e construção de objetos considerando o contexto do cadastro de novos
 * associados
 * <p>
 * Observação: Tenho preferência por utilizar MapperServices gerados por mim ao invés de ModelMapper, pois acredito que
 * eles proporcionem maior flexibilidade com relação a construção dos objetos.
 * <p>
 * Além do mais, ModelMapper podem ser prejudiciais para a performance da aplicação a longo prazo, pois em
 * alguns casos de relacionamentos entre entidades, podem causar gaps de memória. Derrubando a aplicação temporariamente.
 *
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 10:17
 */
@Slf4j
@Service
public class CadastroAssociadoMapperServiceImpl implements CadastroAssociadoMapperService {

    @Override
    public AssociadoEntity geraAssociadoEntityAPartirDeCadastroAssociadoRequest(CadastroAssociadoRequest cadastroAssociadoRequest) {

        log.debug("Mapper service responsavel por gerar AssociadoEntity a partir de CadastroAssociadoRequest acessado");
        log.trace("cadastroAssociadoRequest recebido: {}", cadastroAssociadoRequest);

        log.debug("Iniciando construcao do objeto AssociadoEntity...");
        AssociadoEntity associadoEntity =
                AssociadoEntity.builder()
                        .id(UUID.randomUUID())
                        .nome(cadastroAssociadoRequest.nome())
                        .cpf(cadastroAssociadoRequest.cpf())
                        .build();
        log.debug("Construcao do objeto AssociadoEntity realizada com sucesso");
        log.trace("associadoEntity gerado: {}", associadoEntity);

        log.debug("Retornando objeto AssociadoEntity gerado...");
        return associadoEntity;
    }

    @Override
    public CadastroAssociadoResponse geraAssociadoResponseAPartirDeAssociadoEntity(AssociadoEntity associadoEntity) {

        log.debug("Mapper service responsavel por gerar CadastroAssociadoResponse a partir de AssociadoEntity acessado");
        log.trace("associadoEntity recebido: {}", associadoEntity);

        log.debug("Iniciando construcao do objeto CadastroAssociadoResponse...");
        CadastroAssociadoResponse cadastroAssociadoResponse = new CadastroAssociadoResponse(associadoEntity.getId());
        log.debug("Construcao do objeto CadastroAssociadoResponse realizada com sucesso");
        log.trace("cadastroAssociadoResponse gerado: {}", cadastroAssociadoResponse);

        log.debug("Retornando objeto CadastroAssociadoResponse gerado...");
        return cadastroAssociadoResponse;
    }
}
