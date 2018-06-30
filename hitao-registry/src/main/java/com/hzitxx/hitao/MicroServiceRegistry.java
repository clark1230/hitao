package com.hzitxx.hitao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka 注册服务中心
 */
@EnableEurekaServer
@SpringBootApplication
public class MicroServiceRegistry {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceRegistry.class,args);
    }
}
