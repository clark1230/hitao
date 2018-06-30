package com.hzitxx.hitao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import zipkin.server.EnableZipkinServer;

@SpringBootApplication
public class MicroserviceZipkin {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceZipkin.class,args);
    }
}
