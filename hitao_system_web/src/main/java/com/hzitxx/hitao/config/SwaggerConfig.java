package com.hzitxx.hitao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.google.common.collect.Lists.newArrayList;

//@Configuration
public class SwaggerConfig {

//    @Bean
//    public Docket userApi() {
//        Predicate<RequestHandler> swaggerSelector = RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class);
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .securitySchemes(newArrayList(new ApiKey[]{this.apiKey()}))
////               .securitySchemes(newArrayList(new BasicAuth("test"))) //账号密码登录
////               .enable(false)   //禁止使用
//                .apiInfo(apiInfo())
//                .select()
////               .apis(RequestHandlerSelectors.basePackage("com.boot"))
//                .apis(swaggerSelector)
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title("嗨淘电商后台系统在线API文档")
//                .description("嗨淘电商后台系统在线API文档.....")
//                .license("许可证")
//                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
//                .contact(new Contact("冼耀基","http://www.hzitxx.com","xianyaoji@hzitxx.com"))
//                .version("0.0.1")
//                .build();
//    }
//
//    ApiKey apiKey() {
//        return new ApiKey("sessionId", "sessionId", "header");
//    }
}