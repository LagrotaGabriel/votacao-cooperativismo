package br.com.votacao.modules.pauta.actions.obtencao.paginada.models;

import java.util.List;

public record PautaPageResponse(

        List<ItemPautaPageResponse> conteudoPaginacao,
        Integer numberOfElements,
        Integer pageNumber,
        Integer pageSize,
        Integer size,
        Long totalElements,
        Integer totalPages
) { }