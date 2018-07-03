package com.hzitxx.hitao.route;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.discovery.DiscoveryClientRouteLocator;

public class MyRouteLocator  extends DiscoveryClientRouteLocator {
    public MyRouteLocator(String servletPath, DiscoveryClient discovery,
                          ZuulProperties properties, ServiceInstance localServiceInstance) {
        super(servletPath, discovery, properties, localServiceInstance);
    }


}
