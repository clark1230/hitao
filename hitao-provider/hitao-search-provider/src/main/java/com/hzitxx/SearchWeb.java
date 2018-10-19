package com.hzitxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SearchWeb {
    public static void main(String[] args) {
        SpringApplication.run(SearchWeb.class,args);
    }
}
