package br.com.votacao.modules.voto.actions.cadastro.services.mapper;

import br.com.votacao.modules.associado.entity.AssociadoEntity;
import br.com.votacao.modules.pauta.models.entity.PautaEntity;
import br.com.votacao.modules.voto.actions.cadastro.dto.request.CadastroVotoRequest;
import br.com.votacao.modules.voto.actions.cadastro.dto.response.CadastroVotoResponse;
import br.com.votacao.modules.voto.entity.VotoEntity;

public interface CadastroVotoMapperService {

    VotoEntity geraVotoEntityAPartirDeCadastroVotoRequest(
            CadastroVotoRequest cadastroVotoRequest,
            AssociadoEntity associadoEntity
    );

    CadastroVotoResponse geraVotoResponseAPartirDeVotoEntity(
            PautaEntity pauta,
            VotoEntity votoEntity
    );
}
