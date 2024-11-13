package br.com.votacao.modules.associado.entity;

import br.com.votacao.modules.associado.entity.mock.AssociadoEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Entity: Associado")
class AssociadoEntityTest {

    @Test
    @DisplayName("Deve testar Mock")
    void deveTestarMock() {

        AssociadoEntity associado = AssociadoEntityMock.builder().build();

        Assertions.assertEquals(
                "AssociadoEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, nome=Gabriel Lagrota, cpf=123.189.265-38)",
                associado.toString()
        );
    }

    @Test
    @DisplayName("Deve testar AllArgsConstructor")
    void deveTestarAllArgsConstructor() {

        AssociadoEntity associado = new AssociadoEntity(
                UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e"),
                "Gabriel Lagrota",
                "111.111.111-11"
        );

        Assertions.assertEquals(
                "AssociadoEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, nome=Gabriel Lagrota, cpf=111.111.111-11)",
                associado.toString()
        );
    }

    @Test
    @DisplayName("Deve testar Builder")
    void deveTestarBuilder() {

        AssociadoEntity associadoEntityMock = AssociadoEntityMock.builder().build();

        AssociadoEntity associado = AssociadoEntity.builder()
                .id(associadoEntityMock.getId())
                .nome(associadoEntityMock.getNome())
                .build();

        Assertions.assertEquals(
                "AssociadoEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, nome=Gabriel Lagrota, cpf=null)",
                associado.toString()
        );
    }
}
