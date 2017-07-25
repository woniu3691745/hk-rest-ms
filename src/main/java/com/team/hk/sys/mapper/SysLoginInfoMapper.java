package com.team.hk.sys.mapper;

import com.team.hk.sys.entity.SysUserInfo;

/**
 * Created by lidongliang on 2017/7/25.
 * 系统登录mapper接口
 */
public interface SysLoginInfoMapper {

    /**
     * 系统登陆
     *
     * @param sysUserInfo 系统用户实体
     * @return rowsAffected
     */
    SysUserInfo login(SysUserInfo sysUserInfo);

}
