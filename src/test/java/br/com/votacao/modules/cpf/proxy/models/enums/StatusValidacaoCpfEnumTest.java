package br.com.votacao.modules.cpf.proxy.models.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Enum: StatusValidacaoCpf")
class StatusValidacaoCpfEnumTest {

    @Test
    @DisplayName("Deve testar allArgsConstructor")
    void deveTestarAllArgsConstructor() {

        StatusValidacaoCpfEnum statusValidacaoCpfEnum = StatusValidacaoCpfEnum.ABLE_TO_VOTE;

        Assertions.assertEquals(
                "0, CPF liberado para votar",
                statusValidacaoCpfEnum.getCode() + ", " + statusValidacaoCpfEnum.getDesc()
        );
    }
}
