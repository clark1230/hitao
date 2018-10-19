package com.hzitxx.hitao;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan("com.hzitxx.hitao.mapper.*")
public class AuthenticationService {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationService.class,args);
    }

    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();

    }


    /**
     * ioc容器管理 javabean映射工具 dozer 中Mapper实例
     * @return
     */
    @Bean
    public Mapper mapper(){
        return new DozerBeanMapper();
    }



//    @Bean
//    public Docket swaggerPersonApi10() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.hzitxx.hitao.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(
//                        new ApiInfoBuilder()
//                                .version("1.0")
//                                .title("Original Service API")
//                                .description("Original Service API v1.0")
//                                .build()
//                );
//    }
}
