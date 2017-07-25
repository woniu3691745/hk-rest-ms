package com.team.hk.sys.server;

import com.team.hk.sys.entity.SysUserInfo;

/**
 * Created by lidongliang on 2017/7/25.
 * 系统登录Service接口
 */
public interface SysLoginInfoService {

    /**
     * 系统登陆
     *
     * @param sysUserInfo 系统用户实体
     * @return rowsAffected
     */
    SysUserInfo login(SysUserInfo sysUserInfo);
}
