package br.com.votacao.modules.pauta.actions.obtencao.paginada.models.enums;

import br.com.votacao.modules.pauta.models.enums.StatusPautaEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Enum: StatusPauta")
class StatusPautaEnumTest {

    @Test
    @DisplayName("Deve testar allArgsConstructor")
    void deveTestarAllArgsConstructor() {

        StatusPautaEnum statusPautaEnum = StatusPautaEnum.EM_ABERTO;

        Assertions.assertEquals(
                "0, Em aberto",
                statusPautaEnum.getCode() + ", " + statusPautaEnum.getDesc()
        );
    }
}
