package com.hzitxx.hitao.config;

import com.hzitxx.hitao.filters.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Zuul过滤器配置
 */
@Configuration
public class FilterConfiguration {

//    @Bean
//    public IPFilter ipFilter(){
//        return new IPFilter();
//    }

    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

    /*@Bean
    public CustomZuulFallbackHandler zuulFallbackHandler(){
        return new CustomZuulFallbackHandler();
    }*/

}
