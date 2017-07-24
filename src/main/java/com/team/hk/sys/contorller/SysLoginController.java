package com.team.hk.sys.contorller;

import com.team.hk.sys.entity.MessageInfo;
import com.team.hk.sys.entity.SysUserInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lidongliang on 2017/7/24.
 * 登陆，注册，修改密码接口
 */
public interface SysLoginController {

    /**
     * 系统主页面
     *
     * @param sysUserInfo 用户信息entity
     * @return List<SysUserInfo>
     * >
     */
    List<SysUserInfo> index(SysUserInfo sysUserInfo, HttpServletRequest request);

    /**
     * 系统登陆
     *
     * @param sysUserInfo 用户信息entity
     * @param request     http请求
     * @return List<SysUserInfo>
     */
    String login(SysUserInfo sysUserInfo, HttpServletRequest request);

    /**
     * 系统退出页面
     *
     * @param sysUserInfo 用户信息entity
     * @param request     http请求
     * @return List<SysUserInfo>
     */
    MessageInfo loginOut(SysUserInfo sysUserInfo, HttpServletRequest request);

    /**
     * 注册
     *
     * @param sysUserInfo 用户信息entity
     * @return List<SysUserInfo>
     */
    List<SysUserInfo> register(SysUserInfo sysUserInfo);


    /**
     * 修改密码
     *
     * @param sysUserInfo 用户信息entity
     * @return List<SysUserInfo>
     */
    List<SysUserInfo> changePassword(SysUserInfo sysUserInfo);

}
