package com.hzitxx.hitao.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 日志切面类
 */
@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(LogAspect.class);
    /**
     * 环绕通知
     * @param joinPoint
     */
    @Around("execution(public * com.hzitxx.hitao.controller.*..*(..))")
    public Object log(ProceedingJoinPoint joinPoint){
        try {
           return joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error(throwable.getMessage());
            throwable.printStackTrace();
            return null;
        }
    }
}
