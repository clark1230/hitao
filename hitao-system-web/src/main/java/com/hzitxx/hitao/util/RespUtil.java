package com.hzitxx.hitao.util;


import java.util.List;

/**
 * 响应.....
 */
public class RespUtil<T> {
    private int code;
    private String msg;

    public RespUtil() {
    }

    public RespUtil(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RespUtil(int code, String msg, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private List<T> data;

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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }


}
