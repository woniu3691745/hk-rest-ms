package com.team.hk.sys.entity;

import java.io.Serializable;

/**
 * Created by lidongliang on 2017/7/24.
 * 消息实体
 */
public class MessageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;

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

    @Override
    public String toString() {
        return "MessageInfo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
