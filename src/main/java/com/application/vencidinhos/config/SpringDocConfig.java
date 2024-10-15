package com.application.vencidinhos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Vencidinho's API")
                        .description("Documentação dos endpoints do sistema Vencidinhos")
                        .contact(new Contact()
                                .name("Vencidinhos backend"))
                        .license(new License()
                                .name("Github Vencidinhos")
                                .url("https://github.com/projeto-vencidinhos-ads4/backend")));
    }
}

