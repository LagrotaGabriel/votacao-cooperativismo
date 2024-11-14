package br.com.votacao.modules.pauta.actions.cadastro.services.mapper.impl;

import br.com.votacao.modules.pauta.actions.cadastro.dto.request.CadastroPautaRequest;
import br.com.votacao.modules.pauta.actions.cadastro.dto.response.CadastroPautaResponse;
import br.com.votacao.modules.pauta.actions.cadastro.services.mapper.CadastroPautaMapperService;
import br.com.votacao.modules.pauta.models.entity.PautaEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

/**
 * CadastroPautaMapperServiceImpl
 * Classe responsável por realizar o mapeamento e construção de objetos considerando o contexto do cadastro de novas
 * pautas de votação
 * <p>
 * Observação: Tenho preferência por utilizar MapperServices gerados por mim ao invés de ModelMapper, pois acredito que
 * eles proporcionem maior flexibilidade com relação a construção dos objetos.
 * <p>
 * Além do mais, ModelMapper podem ser prejudiciais para a performance da aplicação a longo prazo, pois em
 * alguns casos de relacionamentos entre entidades, podem causar gaps de memória. Derrubando a aplicação temporariamente.
 *
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 11:31
 */
@Slf4j
@Service
public class CadastroPautaMapperServiceImpl implements CadastroPautaMapperService {

    @Override
    public PautaEntity geraPautaEntityAPartirDeCadastroPautaRequest(CadastroPautaRequest cadastroPautaRequest) {

        log.debug("Mapper service responsavel por gerar PautaEntity a partir de CadastroPautaRequest acessado");
        log.trace("cadastroPautaRequest recebido: {}", cadastroPautaRequest);

        int tempoDuracaoEmMinutos =
                (cadastroPautaRequest.duracaoEmMinutos() == null)
                        ? 1
                        : cadastroPautaRequest.duracaoEmMinutos();

        LocalDateTime dataHoraAtual = LocalDateTime.now();

        log.debug("Iniciando construcao do objeto PautaEntity...");
        PautaEntity pautaEntityEntity =
                PautaEntity.builder()
                        .id(UUID.randomUUID())
                        .titulo(cadastroPautaRequest.titulo())
                        .descricao(cadastroPautaRequest.descricao())
                        .tempoDuracaoEmMinutos(tempoDuracaoEmMinutos)
                        .dataHoraCriacao(dataHoraAtual)
                        .dataHoraExpiracao(dataHoraAtual.plusMinutes(tempoDuracaoEmMinutos))
                        .votos(new ArrayList<>())
                        .build();
        log.debug("Construcao do objeto PautaEntity realizada com sucesso");
        log.trace("pautaEntityEntity gerado: {}", pautaEntityEntity);

        log.debug("Retornando objeto PautaEntity gerado...");
        return pautaEntityEntity;
    }

    @Override
    public CadastroPautaResponse geraPautaResponseAPartirDePautaEntity(PautaEntity pautaEntity) {

        log.debug("Mapper service responsavel por gerar CadastroPautaResponse a partir de PautaEntity acessado");
        log.trace("pautaEntity recebido: {}", pautaEntity);

        log.debug("Iniciando construcao do objeto CadastroPautaResponse...");
        CadastroPautaResponse cadastroPautaResponse =
                new CadastroPautaResponse(
                        pautaEntity.getId(),
                        pautaEntity.getTitulo(),
                        pautaEntity.getDescricao(),
                        pautaEntity.getDataHoraExpiracao()
                );
        log.debug("Construcao do objeto CadastroPautaResponse realizada com sucesso");
        log.trace("cadastroPautaResponse gerado: {}", cadastroPautaResponse);

        log.debug("Retornando objeto CadastroPautaResponse gerado...");
        return cadastroPautaResponse;
    }
}
