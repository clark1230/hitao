package com.hzitxx.hitao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
@EnableCircuitBreaker
@EnableFeignClients
public class MessageApp {
    public static void main(String[] args) {
        SpringApplication.run(MessageApp.class,args);
    }
}
