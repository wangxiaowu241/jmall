package com.xt.open.jmall.cart.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 这是Swagger2的配置文件，必须需要此文件
 * Swagger与工程结合需要引入依赖，已在pom.xml中表明，一共2个依赖
 * <p>
 * swagger2文档的默认地址是 .../swagger-ui.html
 * <p>
 * https://swagger.io/
 *
 * @version 1.0
 * @author yangliu
 * @date 2018-11-25
 */

@Configuration
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 指定controller存放的目录路径
                .apis(RequestHandlerSelectors.basePackage("com.xt.open.jmall.cart.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 文档标题
                .title("jmall Project API Doc")
                // 文档描述
                .description("Swagger2")
                .termsOfServiceUrl("")
                .version("v1")
                .build();
    }
}
