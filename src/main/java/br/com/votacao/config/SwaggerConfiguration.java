package br.com.votacao.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SwaggerConfiguration
 * Classe responsável por definir as configurações globais do Swagger
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 10:34
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "API de votações da cooperativismo", version = "v1"))
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi grupoAssociado() {
        return GroupedOpenApi.builder()
                .group("associados")
                .displayName("Associados")
                .pathsToMatch("/api/srv-votacao/v1/associado/**")
                .build();
    }

    @Bean
    public GroupedOpenApi grupoPauta() {
        return GroupedOpenApi.builder()
                .group("pautas")
                .displayName("Pautas")
                .pathsToMatch("/api/srv-votacao/v1/pauta/**")
                .build();
    }

    @Bean
    public GroupedOpenApi grupoVotacao() {
        return GroupedOpenApi.builder()
                .group("votacoes")
                .displayName("Votações")
                .pathsToMatch("/api/srv-votacao/v1/voto/**")
                .build();
    }

    @Bean
    public GroupedOpenApi grupoCpf() {
        return GroupedOpenApi.builder()
                .group("cpfs")
                .displayName("CPF's")
                .pathsToMatch("/api/srv-votacao/v1/cpf/**")
                .build();
    }
}
