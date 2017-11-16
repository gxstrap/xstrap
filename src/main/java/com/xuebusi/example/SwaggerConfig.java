package com.xuebusi.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @classDesc: 功能描述:(SwaggerConfig)
 * @author: 张全成
 * @createTime: 2017年11月8日 下午7:20:49
 * @version: v1.0
 * 部分注释解释：
 *     @Api：修饰整个类，描述Controller的作用
 *     @ApiOperation：描述一个类的一个方法，或者说一个接口
 *     @ApiParam：单个参数描述
 *     @ApiModel：用对象来接收参数
 *     @ApiProperty：用对象接收参数时，描述对象的一个字段
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xuebusi.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Xstrap利用swagger构建api文档")
                .description("简单优雅的restfun风格，http://blog.csdn.net/forezp")
                .termsOfServiceUrl("http://blog.csdn.net/forezp")
                .version("1.0")
                .build();
    }
}
