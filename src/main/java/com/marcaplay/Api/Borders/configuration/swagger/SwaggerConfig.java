package com.marcaplay.Api.Borders.configuration.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Documentação da API")
                        .version("1.0.0")
                        .description("Esta é a documentação da API usando Springdoc OpenAPI e Swagger UI"));
    }
}
