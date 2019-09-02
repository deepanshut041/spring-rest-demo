package io.github.deepanshut041.serendeepia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Optional;

@Configuration
@EnableSwagger2WebMvc
@Component
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SPRING_WEB)
                .genericModelSubstitutes(Optional.class, ResponseEntity.class)
                .apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Serendeepia REST API")
                .description("Serendeepia Auth REST API")
                .contact(new Contact("Deepanshu Tyagi", "deepanshut041.github.io", "deepanshut041@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0")
                .build();
    }


}
