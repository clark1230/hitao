package com.hzitxx.hitao.util;

/**
 * 响应实体类
 * @param <T>
 */
public class RespUtil<T> {
    private int code;
    private String msg;
    private T t;

    public RespUtil() {
    }

    public RespUtil(int code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.t = t;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
