package com.team.hk.common;

import com.team.hk.sys.entity.SysUserInfo;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lidongliang on 2017/7/31.
 * session 共享数据
 */
@Component
public class RedisEntity {

    private static final String KEY0 = "seid";
    private static final String KEY1 = "userId";
    private static final String KEY2 = "username";
    private static final String KEY3 = "userRole";

    public void setKey(SysUserInfo userInfo, HttpServletRequest request) {
        request.getSession().setAttribute(KEY1, userInfo.getUserId().toString());
        request.getSession().setAttribute(KEY2, userInfo.getUserName());
        request.getSession().setAttribute(KEY3, userInfo.getUserRole());
    }

    public void delKey(HttpServletRequest request) {
        request.getSession().removeAttribute(KEY0);
        request.getSession().removeAttribute(KEY1);
        request.getSession().removeAttribute(KEY2);
        request.getSession().removeAttribute(KEY3);
    }
}
