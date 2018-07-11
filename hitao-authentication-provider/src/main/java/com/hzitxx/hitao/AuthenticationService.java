package com.hzitxx.hitao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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
}
