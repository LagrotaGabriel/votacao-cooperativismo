package br.com.votacao.modules.voto.entity;

import br.com.votacao.modules.associado.entity.mock.AssociadoEntityMock;
import br.com.votacao.modules.voto.entity.enums.TipoVotoEnum;
import br.com.votacao.modules.voto.entity.mock.VotoEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Entity: Voto")
class VotoEntityTest {

    @Test
    @DisplayName("Deve testar Mock")
    void deveTestarMock() {

        VotoEntity voto = VotoEntityMock.builder().build();

        Assertions.assertEquals(
                "VotoEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, tipoVoto=SIM, dataHoraVoto=2024-11-13T15:26)",
                voto.toString()
        );
    }

    @Test
    @DisplayName("Deve testar AllArgsConstructor")
    void deveTestarAllArgsConstructor() {

        VotoEntity voto = new VotoEntity(
                UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e"),
                TipoVotoEnum.SIM,
                LocalDateTime.of(2024, 11, 13, 15, 26, 0),
                AssociadoEntityMock.builder().build()
        );

        Assertions.assertEquals(
                "VotoEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, tipoVoto=SIM, dataHoraVoto=2024-11-13T15:26)",
                voto.toString()
        );
    }

    @Test
    @DisplayName("Deve testar Builder")
    void deveTestarBuilder() {

        VotoEntity votoEntityMock = VotoEntityMock.builder().build();

        VotoEntity voto = VotoEntity.builder()
                .id(votoEntityMock.getId())
                .tipoVoto(votoEntityMock.getTipoVoto())
                .dataHoraVoto(votoEntityMock.getDataHoraVoto())
                .associado(votoEntityMock.getAssociado())
                .build();

        Assertions.assertEquals(
                "VotoEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, tipoVoto=SIM, dataHoraVoto=2024-11-13T15:26)",
                voto.toString()
        );
    }
}
