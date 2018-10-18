package com.hzitxx.hitao.filters;

import com.alibaba.fastjson.JSON;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.jwt.Audience;
import com.hzitxx.hitao.jwt.JwtHelper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 令牌过滤器
 */
@ConfigurationProperties(prefix = "unauthurl")
@Component
public class TokenFilter extends ZuulFilter {
    @Autowired
    private Audience audience;

    private List<String> nonUrl = new ArrayList<>();

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
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        final HttpServletResponse response = requestContext.getResponse();
        final HttpServletRequest request = requestContext.getRequest();
        requestContext.getResponse().setContentType("applicationn/json;charset=utf-8");
        String url = request.getRequestURI();

        if (nonUrl != null && nonUrl.contains(url) || url.contains("v2")) { //这些请求地址不需要token!
           return  null;
        } else {
            //获取token
            final String token = request.getHeader("token");
            if (StringUtils.isNotBlank(token)) {
                if (audience == null) {
                    BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
                    audience = (Audience) factory.getBean("audience");
                }
                final Claims claims = JwtHelper.parseJWT(token, audience.getBase64Secret());
                if (claims == null) {
                    requestContext.setSendZuulResponse(false);
                    //无效的token
                    requestContext.setResponseBody(JSON.toJSONString(ServerResponse.createByErrorCodeMessage(4000,"无效的token!")));
                    return null;
                }else {
                    //添加自定义请求头
                    //bug  ---> 如果经过负载均衡服务，memberid就会传递不到代理的微服务中
                    requestContext.addZuulRequestHeader("memberId",claims.get("userid").toString());
                    return null;
                }
            } else {
               // requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(4001);
                //请传入token
                requestContext.setResponseBody(JSON.toJSONString(
                        ServerResponse.createByErrorCodeMessage(4001,"该请求必须携带token参数!")));
                return null;
            }
        }
    }

    public List<String> getNonUrl() {
        return nonUrl;
    }

    public void setNonUrl(List<String> nonUrl) {
        this.nonUrl = nonUrl;
    }
}

