package com.muebleria.Documentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/*
Nota: A partir de Spring Boot 2.6 y superiores, puede haber conflictos con Springfox. Asegúrate de usar versiones compatibles.
*/

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.muebleria"))
                .paths(PathSelectors.any())
                .build();
    }
}