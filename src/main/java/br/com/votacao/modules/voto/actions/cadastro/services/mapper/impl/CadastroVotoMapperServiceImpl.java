package br.com.votacao.modules.voto.actions.cadastro.services.mapper.impl;

import br.com.votacao.modules.associado.entity.AssociadoEntity;
import br.com.votacao.modules.pauta.entity.PautaEntity;
import br.com.votacao.modules.voto.actions.cadastro.dto.request.CadastroVotoRequest;
import br.com.votacao.modules.voto.actions.cadastro.dto.response.CadastroVotoResponse;
import br.com.votacao.modules.voto.actions.cadastro.services.mapper.CadastroVotoMapperService;
import br.com.votacao.modules.voto.entity.VotoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * CadastroPautaMapperServiceImpl
 * Classe responsável por realizar o mapeamento e construção de objetos considerando o contexto do cadastro de um voto
 * em uma pauta
 * <p>
 * Observação: Tenho preferência por utilizar MapperServices gerados por mim ao invés de ModelMapper, pois acredito que
 * eles proporcionem maior flexibilidade com relação a construção dos objetos.
 * <p>
 * Além do mais, ModelMapper podem ser prejudiciais para a performance da aplicação a longo prazo, pois em
 * alguns casos de relacionamentos entre entidades, podem causar gaps de memória. Derrubando a aplicação temporariamente.
 *
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 16:55
 */
@Slf4j
@Service
public class CadastroVotoMapperServiceImpl implements CadastroVotoMapperService {

    @Override
    public VotoEntity geraVotoEntityAPartirDeCadastroVotoRequest(CadastroVotoRequest cadastroVotoRequest,
                                                                 AssociadoEntity associadoEntity) {

        log.debug("Mapper service responsavel por gerar VotoEntity a partir de CadastroVotoRequest acessado");
        log.trace("cadastroVotoRequest recebido: {}", cadastroVotoRequest);

        log.debug("Iniciando construcao do objeto VotoEntity...");
        VotoEntity votoEntity =
                VotoEntity.builder()
                        .id(UUID.randomUUID())
                        .tipoVoto(cadastroVotoRequest.voto())
                        .dataHoraVoto(LocalDateTime.now())
                        .associado(associadoEntity)
                        .build();
        log.debug("Construcao do objeto VotoEntity realizada com sucesso");
        log.trace("votoEntity gerado: {}", votoEntity);

        log.debug("Retornando objeto VotoEntity gerado...");
        return votoEntity;
    }

    @Override
    public CadastroVotoResponse geraVotoResponseAPartirDeVotoEntity(PautaEntity pauta,
                                                                    VotoEntity votoEntity) {

        log.debug("Mapper service responsavel por gerar CadastroVotoResponse a partir de VotoEntity acessado");
        log.trace("votoEntity recebido: {}", votoEntity);

        log.debug("Iniciando construcao do objeto CadastroVotoResponse...");
        CadastroVotoResponse cadastroVotoResponse =
                new CadastroVotoResponse(
                        votoEntity.getId(),
                        pauta.getVotos().size()
                );
        log.debug("Construcao do objeto CadastroVotoResponse realizada com sucesso");
        log.trace("cadastroVotoResponse gerado: {}", cadastroVotoResponse);

        log.debug("Retornando objeto CadastroVotoResponse gerado...");
        return cadastroVotoResponse;
    }
}
