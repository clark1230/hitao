package com.hzitxx.hitao.config;

import com.hzitxx.hitao.route.CustomRouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 路由配置
 */
@Configuration
public class CustomZuulConfig {

    @Autowired
    ZuulProperties zuulProperties;

    @Autowired
    ServerProperties server;



    /**
     * 路由定位器
     * @return
     */
    @Bean
    public CustomRouteLocator routeLocator() {
        System.out.println("路由定位器");
        System.out.println(this.server.getServlet().getServletPrefix());
        CustomRouteLocator routeLocator = new CustomRouteLocator("/",
                this.zuulProperties);
        return routeLocator;
    }
}
