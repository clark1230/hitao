package com.hzitxx.hitao.utils;

import java.util.List;

/**
 * layui接收的分页数据格式
 * {
 code: 0,
 msg: "",
 count: 1000,
 data: []
 }
 */
public class LayuiEntity<T> {
    private int code;
    private String msg;
    private long count;
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

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
