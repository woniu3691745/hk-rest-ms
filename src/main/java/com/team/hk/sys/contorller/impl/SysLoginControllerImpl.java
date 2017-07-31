package com.team.hk.sys.contorller.impl;

import com.team.hk.common.RedisEntity;
import com.team.hk.sys.contorller.SysLoginController;
import com.team.hk.sys.entity.MessageInfo;
import com.team.hk.sys.entity.SysUserInfo;
import com.team.hk.sys.server.SysLoginInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

/**
 * Created by lidongliang on 2017/7/24.
 * 登陆，注册，修改密码实现类
 */
@Controller
@RequestMapping("/api")
public class SysLoginControllerImpl implements SysLoginController {

    private static Logger logger = Logger.getLogger(SysLoginControllerImpl.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private SysLoginInfoService sysLoginInfoService;

    @Autowired
    private RedisEntity redisEntity;
    /**
     * 登陆
     *
     * @param sysUserInfo 用户信息entity
     * @param request     http请求
     * @return MessageInfo
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @Override
    public MessageInfo login(@RequestBody SysUserInfo sysUserInfo, HttpServletRequest request,
                             HttpServletResponse response) {
        MessageInfo messageInfo = new MessageInfo();
        SysUserInfo userInfo = sysLoginInfoService.login(sysUserInfo);
        if (Objects.nonNull(userInfo)) {
            // 获得sessionId
            String seid = request.getSession().getId();
            logger.debug("seid = " + seid);
            request.getSession().setAttribute("seid", seid);

            messageInfo.setCode(200);
            messageInfo.setMsg("登录系统成功！");
            messageInfo.setCookie(seid);
            messageInfo.setT(userInfo);
            redisEntity.setKey(userInfo, request);
            logger.debug(userInfo.getUserName() + " 登录系统成功");
            return messageInfo;
        } else {
            messageInfo.setCode(500);
            messageInfo.setMsg("登录失败，账号或密码错误！");
            return messageInfo;
        }
    }

    /**
     * 退出
     *
     * @param request http请求
     * @return MessageInfo
     */
    @ResponseBody
    @RequestMapping(value = "/loginOut", method = RequestMethod.POST)
    @Override
    public MessageInfo loginOut(HttpServletRequest request) {

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode(200);
        messageInfo.setMsg("退出系统成功!");

        logger.debug(request.getSession().getAttribute("username") + " 退出系统");
        redisEntity.delKey(request);
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
