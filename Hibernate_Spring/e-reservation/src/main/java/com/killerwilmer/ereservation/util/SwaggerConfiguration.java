package com.killerwilmer.ereservation.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** @author killerwilmer */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  public Docket documentation() {
    return new Docket(DocumentationType.SPRING_WEB.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
        .paths(PathSelectors.any())
        .build();
  }
}
