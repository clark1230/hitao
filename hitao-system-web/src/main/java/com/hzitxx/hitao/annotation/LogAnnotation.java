package com.hzitxx.hitao.annotation;

/**
 * 自定义日志注解
 */
public @interface LogAnnotation {

    /**
     * 方法名称
     * @return
     */
    String method() default  "";

    /**
     * 模块
     * @return
     */
    String module() default  "";

    /**
     * 消息
     * @return
     */
    String msg() default  "";


}
