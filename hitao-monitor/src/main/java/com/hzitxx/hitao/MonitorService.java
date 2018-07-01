package com.hzitxx.hitao;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
//@EnableHystrix
//@EnableHystrixDashboard
//@EnableCircuitBreaker
//@EnableTurbine
public class MonitorService {
    public static void main(String[] args) {
        SpringApplication.run(MonitorService.class,args);
    }
}
