package com.hzitxx.hitao.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hzitxx.hitao.commons.ServerResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *参数验证切面类
 */
@Aspect
@Component
public class ValidateParamAspect {

    private Logger logger = LoggerFactory.getLogger(ValidateParamAspect.class);
    /**
     * 环绕通知---校验参数是否正确
     * @param joinPoint
     */
    @Around(value = "execution(public * com.hzitxx.hitao.controller..*(..))")
    public Object around(ProceedingJoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        Object[] objArr =  joinPoint.getArgs();
        BindingResult bindingResult = null;
        if(objArr.length >0){
              int length = objArr.length;
              for(int i=0;i<objArr.length;i++){
                  if(objArr[i] instanceof  BindingResult){
                      bindingResult = (BindingResult)objArr[i];
                      break; //结束循环
                  }
              }
        }
        JSONObject jsonObject = null;
        if(bindingResult != null&& bindingResult.hasFieldErrors()){
            HttpServletResponse resp = attributes.getResponse();
            jsonObject = new JSONObject();
            for(FieldError fieldError : bindingResult.getFieldErrors()){
                jsonObject.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            resp.setContentType("application/json;charset=utf-8");
            try {
                PrintWriter printWriter = resp.getWriter();
                printWriter.write(JSON.toJSONString(ServerResponse.createByError(jsonObject)));
                printWriter.flush();//刷新缓存
            } catch (IOException e) {
                logger.error("错误:"+e.getMessage());
                e.printStackTrace();
            }
            //return  new ResponseEntity<ServerResponse>(ServerResponse.createByError(jsonObject),HttpStatus.OK);
        }else{
            try {

                Object obj = joinPoint.proceed();//执行目标方法
                return  obj;
            } catch (Throwable throwable) {
                logger.error("错误:"+throwable.getMessage());
                throwable.printStackTrace();
            }
        }
        return null;
    }
}
