package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.RefreshRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态路由控制器
 */
@RestController
public class RefreshRouteController {

    @Autowired
    RefreshRouteService refreshRouteService;

    @Autowired
    ZuulHandlerMapping zuulHandlerMapping;

    /**
     * 刷新路由
     * @return
     */
    @GetMapping("/refreshRoute")
    public ServerResponse<String> refresh() {
        return refreshRouteService.refreshRoute();
    }

    /**
     * 查看路由
     * @return
     */
    @RequestMapping("/watchRoute")
    public ServerResponse watchNowRoute() {
        Map<String, Object> handlerMap = zuulHandlerMapping.getHandlerMap();
        System.out.println(handlerMap);
        Map<String,Object> map = new HashMap<>();
        map.put("/**","");
        return ServerResponse.createBySuccess(handlerMap);
    }
}
