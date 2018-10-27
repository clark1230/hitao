package com.hzitxx.hitao.config;

import com.alibaba.fastjson.JSON;
import com.hzitxx.hitao.commons.ServerResponse;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


public class CustomZuulFallbackHandler  implements FallbackProvider {
    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable throwable) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_GATEWAY;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 502;
            }

            @Override
            public String getStatusText() throws IOException {
                return "Bad Gateway";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                String json = JSON.toJSONString(
                        ServerResponse.createByErrorCodeMessage(5000,
                                "微服务调用失败!请稍后再尝试!"));
                return new ByteArrayInputStream(json.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}