package com.hzitxx.hitao.ratelimit;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.RateLimitKeyGenerator;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyRateLimit  implements RateLimitKeyGenerator {
    @Override
    public String key(HttpServletRequest httpServletRequest, Route route, RateLimitProperties.Policy policy) {
        System.out.println("服务限流....");
        return null;
    }
}
