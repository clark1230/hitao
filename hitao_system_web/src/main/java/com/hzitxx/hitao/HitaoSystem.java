package com.hzitxx.hitao;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Properties;

/**
 * 入口
 */
@SpringBootApplication
@MapperScan("com.hzitxx.hitao.mapper.*")
@EnableSwagger2
public class HitaoSystem{
    public static void main(String[] args) {
        SpringApplication.run(HitaoSystem.class,args);
    }

    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper(){
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        //properties.setProperty("params", "pageNum=page;pageSize=limit;orderBy=orderBy");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
