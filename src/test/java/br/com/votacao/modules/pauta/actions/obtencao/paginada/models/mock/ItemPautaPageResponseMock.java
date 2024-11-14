package br.com.votacao.modules.pauta.actions.obtencao.paginada.models.mock;

import br.com.votacao.modules.pauta.actions.obtencao.paginada.models.ItemPautaPageResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemPautaPageResponseMock {

    private ItemPautaPageResponse itemPautaPageResponse;

    private ItemPautaPageResponseMock() {
    }

    public static ItemPautaPageResponseMock builder() {

        ItemPautaPageResponseMock builder = new ItemPautaPageResponseMock();

        builder.itemPautaPageResponse =
                new ItemPautaPageResponse(
                        UUID.fromString("f2ac6801-6cad-4408-b002-31d00314f493"),
                        "Legalização do @Data",
                        "Nessa pauta votaremos se o @Data deverá ou não ser legalizado nesta API",
                        "Encerrada",
                        3,
                        2,
                        1,
                        LocalDateTime.of(2024, 11, 13, 23, 56),
                        LocalDateTime.of(2024, 11, 13, 23, 57)
                );

        return builder;
    }

    public List<ItemPautaPageResponse> buildList() {

        List<ItemPautaPageResponse> itemPautaPageResponseList = new ArrayList<>();
        itemPautaPageResponseList.add(this.itemPautaPageResponse);

        return itemPautaPageResponseList;
    }

    public ItemPautaPageResponse build() {
        return itemPautaPageResponse;
    }
}
