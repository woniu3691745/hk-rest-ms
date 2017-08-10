package com.team.hk.sys.entity;

import java.io.Serializable;

/**
 * Created by lidongliang on 2017/7/24.
 * 消息实体
 */
public class MessageInfo<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;       // 状态码
    private String msg;     // 消息
    private String msg1;    // 消息1
    private String cookie;  // Cookie
    private T t;            // 对象

    public MessageInfo() {
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

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getMsg1() {
        return msg1;
    }

    public void setMsg1(String msg1) {
        this.msg1 = msg1;
    }
}
