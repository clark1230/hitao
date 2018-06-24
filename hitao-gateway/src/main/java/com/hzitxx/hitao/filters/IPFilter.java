package com.hzitxx.hitao.filters;

import com.alibaba.fastjson.JSON;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.utils.IPUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;

/**
 * IP黑名单过滤器
 */
public class IPFilter extends ZuulFilter {
    @Value("${ip}")
    private String ip;

    @Override
    public String filterType() {
        return FilterType.PRE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        Object success= requestContext.get("isSuccess");
        return success == null ? true :Boolean.parseBoolean(success.toString());
    }

    @Override
    public Object run() {
       // System.out.println("ip黑名单过滤器");
        RequestContext requestContext = RequestContext.getCurrentContext();//获取请求上下文
        String ip = IPUtil.getIpAddr(requestContext.getRequest());//获取真实客户端ip地址
       // System.out.println("ip地址为:"+ip);
        System.out.println(this.ip.contains(ip));
        if(StringUtils.isNotBlank(ip) && StringUtils.isNotBlank(this.ip) && this.ip.contains(ip)){
           // System.out.println("非法访问!!");
            requestContext.set("isSuccess",false);
            requestContext.setSendZuulResponse(false);
            requestContext.getResponse().setContentType("application/json;charset=utf-8");
            String json = JSON.toJSONString(ServerResponse.createByErrorCodeMessage(401,"非法的IP地址"));
            requestContext.setResponseBody(json);
            return null;
        }
        return null;
    }
}
