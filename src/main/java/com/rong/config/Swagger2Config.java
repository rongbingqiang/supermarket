package com.rong.config;

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
 * @title: Swagger2Config
 * @projectName zhifu
 * @description: TODO
 * @author 荣兵强
 * @date 2022/2/2618:38
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("资源管理")
                .select()
              //  .apis(RequestHandlerSelectors.basePackage("com.lishiots.dc.baseinfo.ctl"))
                .paths(PathSelectors.any())
                .build();
    }
    @Bean
    public Docket createMonitorRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("实时监测")
                .select()
             //   .apis(RequestHandlerSelectors.basePackage("com.lishiots.dc.monitor.ctl"))
                .paths(PathSelectors.any())
                .build();
    }
    @Bean
    public Docket createActivitiRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("工作流引擎")
                .select()
              //  .apis(RequestHandlerSelectors.basePackage("com.lishiots.dc.activiti.ctl"))
                .paths(PathSelectors.any())
                .build();
    }
    @Bean
    public Docket createBaseRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("kernel模块")
                .select()
              //  .apis(RequestHandlerSelectors.basePackage("com.lishiots.dc.kernel.ctl"))
                .paths(PathSelectors.any())
                .build();
    }
    @Bean
    public Docket createComplaintRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("投诉管理")
                .select()
             //   .apis(RequestHandlerSelectors.basePackage("com.lishiots.dc.complaint.ctl"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("\"超市支付案例接口\"")
                .description("swagger RESTful APIs")
//                .termsOfServiceUrl("http://www.test.com/")
//                .contact("xiaoymin@foxmail.com")
                .version("1.0")
                .build();
    }
}