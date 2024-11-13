package br.com.votacao.modules.pauta.entity;

import br.com.votacao.modules.pauta.entity.mock.PautaEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Entity: Pauta")
class PautaEntityTest {

    @Test
    @DisplayName("Deve testar Mock")
    void deveTestarMock() {

        PautaEntity pauta = PautaEntityMock.builder().build();

        Assertions.assertEquals(
                "PautaEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, titulo=Legalização do @Data, " +
                        "descricao=Nessa pauta votaremos se o @Data deverá ou não ser legalizado nesta API, " +
                        "tempoDuracaoEmMinutos=3, dataHoraCriacao=2024-11-13T15:26, " +
                        "dataHoraExpiracao=2024-11-13T15:29)",
                pauta.toString()
        );
    }

    @Test
    @DisplayName("Deve testar AllArgsConstructor")
    void deveTestarAllArgsConstructor() {

        PautaEntity pauta = new PautaEntity(
                UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e"),
                "Legalização do @Data",
                "Nessa pauta votaremos se o @Data deverá ou não ser legalizado nesta API",
                5,
                LocalDateTime.of(2024, 11, 13, 15, 26, 0),
                LocalDateTime.of(2024, 11, 13, 15, 29, 0),
                new ArrayList<>()
        );

        Assertions.assertEquals(
                "PautaEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, titulo=Legalização do @Data, " +
                        "descricao=Nessa pauta votaremos se o @Data deverá ou não ser legalizado nesta API, " +
                        "tempoDuracaoEmMinutos=5, dataHoraCriacao=2024-11-13T15:26, dataHoraExpiracao=2024-11-13T15:29)",
                pauta.toString()
        );
    }

    @Test
    @DisplayName("Deve testar Builder")
    void deveTestarBuilder() {

        PautaEntity pautaEntityMock = PautaEntityMock.builder().build();

        PautaEntity pauta = PautaEntity.builder()
                .id(pautaEntityMock.getId())
                .titulo(pautaEntityMock.getTitulo())
                .descricao(pautaEntityMock.getDescricao())
                .tempoDuracaoEmMinutos(pautaEntityMock.getTempoDuracaoEmMinutos())
                .dataHoraCriacao(pautaEntityMock.getDataHoraCriacao())
                .dataHoraExpiracao(pautaEntityMock.getDataHoraExpiracao())
                .votos(pautaEntityMock.getVotos())
                .build();

        Assertions.assertEquals(
                "PautaEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, titulo=Legalização do @Data, " +
                        "descricao=Nessa pauta votaremos se o @Data deverá ou não ser legalizado nesta API, " +
                        "tempoDuracaoEmMinutos=3, dataHoraCriacao=2024-11-13T15:26, dataHoraExpiracao=2024-11-13T15:29)",
                pauta.toString()
        );
    }
}
