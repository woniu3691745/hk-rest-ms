package com.team.hk.sys.contorller.impl;

import com.team.hk.sys.contorller.SysLoginController;
import com.team.hk.sys.entity.MessageInfo;
import com.team.hk.sys.entity.SysUserInfo;
import com.team.hk.sys.server.SysUserInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lidongliang on 2017/7/24.
 * 登陆，注册，修改密码实现类
 */
@Controller
@RequestMapping("/api")
public class SysLoginControllerImpl implements SysLoginController {

    private static Logger logger = Logger.getLogger(SysLoginControllerImpl.class);

    @Autowired
    private SysUserInfoService sysUserInfoService;

    /**
     * 主页
     *
     * @param sysUserInfo 用户信息entity
     * @return List<SysUserInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @Override
    public List<SysUserInfo> index(@RequestBody SysUserInfo sysUserInfo, HttpServletRequest request) {
        return sysUserInfoService.getAllSysUserInfoService(sysUserInfo);
    }

    /**
     * 登陆
     *
     * @param sysUserInfo 用户信息entity
     * @param request     http请求
     * @return MessageInfo
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @Override
    public String login(SysUserInfo sysUserInfo, HttpServletRequest request) {
        // 获得sessionId
        String seid = request.getSession().getId();
        request.getSession().setAttribute("seid", seid);
        System.out.println("/login = " + request.getSession().getAttribute("seid"));
        return "/login";
    }


    @ResponseBody
    @RequestMapping(value = "/method", method = RequestMethod.GET)
    public String getTest(HttpServletRequest request) {
        System.out.println("/method = " + request.getSession().getAttribute("seid"));
        return request.getSession().getAttribute("seid").toString();
    }

    /**
     * 退出
     *
     * @param sysUserInfo 用户信息entity
     * @param request     http请求
     * @return MessageInfo
     */
    @ResponseBody
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    @Override
    public MessageInfo loginOut(SysUserInfo sysUserInfo, HttpServletRequest request) {
        request.getSession().removeAttribute("seid");
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode(200);
        messageInfo.setMsg("退出成功!");
        return messageInfo;
    }

    /**
     * 注册
     *
     * @param sysUserInfo 用户信息entity
     * @return List<SysUserInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @Override
    public List<SysUserInfo> register(@RequestBody SysUserInfo sysUserInfo) {
        return null;
    }

    /**
     * 修改密码
     *
     * @param sysUserInfo 用户信息entity
     * @return List<SysUserInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    @Override
    public List<SysUserInfo> changePassword(@RequestBody SysUserInfo sysUserInfo) {
        return null;
    }
}
