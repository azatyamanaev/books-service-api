package ru.itis.booksservice.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI springLibraryOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Library API")
                        .version("v0.0.10"));
    }
}
