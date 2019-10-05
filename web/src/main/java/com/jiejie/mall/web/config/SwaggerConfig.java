package com.jiejie.mall.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ConditionalOnProperty(name = "swagger2.enabled", havingValue = "true")
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger2.title:swagger2.title:没设置}")
    private String title;
    @Value("${swagger2.desc:swagger2.desc:没设置}")
    private String desc;
    @Value("${swagger2.version:swagger2.version:没设置}")
    private String version;
    //    @Value("${swagger2.contact:swagger2.contact:没设置}")
//    private String contact;
    @Value("${swagger2.url:swagger2.url:没设置}")
    private String url;
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .enable(enableRestApi)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jiejie.mall.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(desc)
                .termsOfServiceUrl(url)
                .contact(new Contact("Baidu", "https://www.baidu.com", null))
                .version(version)
                .build();
    }

}
