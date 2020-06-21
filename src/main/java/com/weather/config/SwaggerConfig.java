package com.weather.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final ApiInfo apiInfo = new ApiInfo(
        "Weather provider",
        "A simple weather provider service",
        "1.0.0",
        "",
        new Contact("Sasan Yavari", "http://www.linkedin.com/in/sasan-yavari", "s.yavari@gmail.com"),
        "",
        "",
        Collections.emptyList()
    );

    /**
     * Swagger Docket bean creator.
     *
     * @return an instance of Docket.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.weather.rest"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo);
    }
}