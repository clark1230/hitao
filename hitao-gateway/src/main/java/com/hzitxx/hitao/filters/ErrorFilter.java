package com.hzitxx.hitao.filters;

import com.alibaba.fastjson.JSON;
import com.hzitxx.hitao.commons.ServerResponse;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常过滤器
 */
public class ErrorFilter  extends ZuulFilter {

    private static final String ERROR_STATUS_CODE_KEY = "error.status_code";

    public static final String DEFAULT_ERR_MSG = "系统繁忙,请稍后再试";
    @Override
    public String filterType() {
        return FilterType.ERROR;
    }

    @Override
    public int filterOrder() {
        return 9;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return ctx.containsKey(ERROR_STATUS_CODE_KEY);
    }

    /**
     * 统一异常处理!
     * @return
     */
    @Override
    public Object run() {
        System.out.println("统一异常过滤器...");
       /* System.out.println("统一异常过滤器...");
        RequestContext rct = RequestContext.getCurrentContext();
        Throwable throwable = rct.getThrowable();
        rct.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        rct.set("error.exception",throwable.getCause());
        String json = JSON.toJSONString(ServerResponse.createByErrorMessage("服务器异常!"));
        rct.setSendZuulResponse(false);
        rct.getResponse().setContentType("application/json;charset=utf-8");
        rct.setResponseBody(json);
        return null;*/
        RequestContext ctx = RequestContext.getCurrentContext();

        try {
            HttpServletRequest request = ctx.getRequest();

            int statusCode = (Integer) ctx.get(ERROR_STATUS_CODE_KEY);
            String message = (String) ctx.get("error.message");
            if (ctx.containsKey("error.exception")) {
                Throwable e = (Exception) ctx.get("error.exception");
                Throwable re = getOriginException(e);
                if(re instanceof java.net.ConnectException){
                    message = "Real Service Connection refused";
                }else if(re instanceof java.net.SocketTimeoutException){
                    message = "Real Service Timeout";
                }else if(re instanceof com.netflix.client.ClientException){
                    message = re.getMessage();
                }else{
                }
            }
            if(StringUtils.isBlank(message)){
                message = DEFAULT_ERR_MSG;
            }
            request.setAttribute("javax.servlet.error.status_code", statusCode);
            request.setAttribute("javax.servlet.error.message", message);
            String json = JSON.toJSONString(ServerResponse.createByErrorCodeMessage(statusCode,message));
            ctx.setSendZuulResponse(false);
            ctx.getResponse().setContentType("application/json;charset=utf-8");
            ctx.setResponseBody(json);
        } catch (Exception e) {
            String error = "Error during filtering[ErrorFilter]";
            String json = JSON.toJSONString(ServerResponse.createByErrorCodeMessage(500,DEFAULT_ERR_MSG));
            ctx.setSendZuulResponse(false);
            ctx.getResponse().setContentType("application/json;charset=utf-8");
            ctx.setResponseBody(json);
        }
        return null;
    }
    private Throwable getOriginException(Throwable e){
        e = e.getCause();
        while(e.getCause() != null){
            e = e.getCause();
        }
        return e;
    }
}
