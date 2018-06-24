package com.hzitxx.hitao;

import com.hzitxx.hitao.sender.Sender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableBinding(Sender.class)
public class MiscroserviceBus {
    public static void main(String[] args) {
        SpringApplication.run(MiscroserviceBus.class,args);
    }
}
