package com.hzitxx.hitao.service.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.RefreshRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * 刷新路由
 */
@Service
public class RefreshRouteServiceImpl implements RefreshRouteService {

    @Autowired
    ApplicationEventPublisher publisher;
//
//    @Autowired
//    RouteLocator routeLocator;

    /**
     * 刷新路由
     * @return
     */
    public ServerResponse<String> refreshRoute() {
       // RoutesRefreshedEvent routesRefreshedEvent = new RoutesRefreshedEvent(routeLocator);
        try{
          //  publisher.publishEvent(routesRefreshedEvent);
            return  ServerResponse.createBySuccessMessage("路由刷新成功!");
        }catch (Exception e){
            return ServerResponse.createByErrorMessage("路由刷新失败!");
        }

    }
}
