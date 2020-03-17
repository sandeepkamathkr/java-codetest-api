package com.sandeepkamathkr.webservice.config.swagger;

import com.sandeepkamathkr.webservice.config.swagger.properties.SwaggerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.Date;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@EnableConfigurationProperties({SwaggerProperties.class})
public class SwaggerConfiguration {
    /**
     * Api docket for custom config swagger
     *
     * @param swaggerProperties the swagger properties
     * @return the docket
     */
    @Bean
    public Docket swaggerDocket(SwaggerProperties swaggerProperties){
        return new Docket(DocumentationType.SWAGGER_2)
                .forCodeGeneration(true)
                .ignoredParameterTypes(java.sql.Date.class)
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
                .select()
                .paths(regex(swaggerProperties.getDefaultIncludePattern()))
                .build();
    }
}
