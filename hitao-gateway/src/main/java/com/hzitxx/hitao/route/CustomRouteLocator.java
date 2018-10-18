package com.hzitxx.hitao.route;

import com.hzitxx.hitao.service.IGatewayApiDefineService;
import com.hzitxx.hitao.system.pojo.GatewayApiDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自定义路由器
 */
public class CustomRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    public final static Logger logger = LoggerFactory.getLogger(CustomRouteLocator.class);

    private AtomicReference<Map<String,ZuulRoute>>
            routes = new AtomicReference<>();

    @Autowired
    private IGatewayApiDefineService gatewayApiDefineService;

    private ZuulProperties properties;

    public CustomRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath,  properties);
        this.properties = properties;

    }



    @Override
    protected Map<String, ZuulRoute> locateRoutes() {
        LinkedHashMap<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<>();
        //从application.properties中加载路由信息
        routesMap.putAll(super.locateRoutes());
        //从db中加载路由信息
        routesMap.putAll(locateRoutesFromDB());
        LinkedHashMap<String, ZuulProperties.ZuulRoute> values = new LinkedHashMap<>();
        for (Map.Entry<String, ZuulRoute> entry : routesMap.entrySet()) {
            String path = entry.getKey();
            if (!path.startsWith("/")) {
                path = "/" + path;
            }
            if (StringUtils.hasText(this.properties.getPrefix())) {
                path = this.properties.getPrefix() + path;
                if (!path.startsWith("/")) {
                    path = "/" + path;
                }
            }
            values.put(path, entry.getValue());
        }
        return values;
    }

    /**
     * 从数据库加载路由信息
     *
     * @return
     */
    private Map<String, ZuulRoute> locateRoutesFromDB() {
        // 准备一个map集合存放路由信息
        Map<String, ZuulRoute> routes = new LinkedHashMap<>();
        Map<String,Object> map = new HashMap<>();
        map.put("enabled",0);
        //从数据库中获取路由信息
        List<GatewayApiDefine> gatewayApiDefines = gatewayApiDefineService.searchGatewayApiDefine(map).getData();
        for (GatewayApiDefine result : gatewayApiDefines) {
            if (StringUtils.isEmpty(result.getPath())) {
                continue;
            }
            if (StringUtils.isEmpty(result.getServiceId()) && StringUtils.isEmpty(result.getUrl())) {
                continue;
            }
            ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
            try {
                BeanUtils.copyProperties(result, zuulRoute);
            } catch (Exception e) {
                logger.error("=============从数据库加载路由信息失败!==============", e);
            }
            // 添加路由信息到map集合中
            routes.put(zuulRoute.getPath(), zuulRoute);
        }
        return routes;
    }

    @Override
    public void refresh() {
        super.doRefresh();
    }


}
