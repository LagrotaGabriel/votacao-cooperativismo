package br.com.votacao.modules.pauta.actions.cadastro.services.mapper;

import br.com.votacao.modules.pauta.actions.cadastro.dto.request.CadastroPautaRequest;
import br.com.votacao.modules.pauta.actions.cadastro.dto.response.CadastroPautaResponse;
import br.com.votacao.modules.pauta.models.entity.PautaEntity;

public interface CadastroPautaMapperService {

    PautaEntity geraPautaEntityAPartirDeCadastroPautaRequest(
            CadastroPautaRequest cadastroPautaRequest
    );

    CadastroPautaResponse geraPautaResponseAPartirDePautaEntity(
            PautaEntity pautaEntity
    );
}
