package com.hzitxx.hitao.filters;

/**
 * 过滤器类型
 */
public interface FilterType {
    String PRE ="pre";//在请求被路由之前调用
    String ROUTE = "route";//在路由请求时被调用
    String POST = "post"; //在route和error过滤器之后被调用
    String ERROR = "error";//处理请求发生错误时被调用
}
