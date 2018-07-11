package com.hzitxx.hitao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class GatewayService {
    public static void main(String[] args) {
        SpringApplication.run(GatewayService.class,args);
    }

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return null;
//    }

    /**
     * 配置负载均衡
     * @return
     */
    @Bean
    public RestTemplate template(){
        return  new RestTemplate();
    }

    @Bean
    public RouteLocator productRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(t -> t.path("/produt/**")
                    .and()
                    .uri("http://localhost:8095/**"))
            .build();
    }

    @Bean
    public RouteLocator authcRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(t -> t.path("/user/**")
                        .and().predicate( e -> {
                            return false;
                        })
                        .uri("http://localhost:8091/login"))
                .build();
    }

    @Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }
}
