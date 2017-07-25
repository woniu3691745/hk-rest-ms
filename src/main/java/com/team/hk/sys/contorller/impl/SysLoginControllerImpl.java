package com.team.hk.sys.contorller.impl;

import com.team.hk.sys.contorller.SysLoginController;
import com.team.hk.sys.entity.MessageInfo;
import com.team.hk.sys.entity.SysUserInfo;
import com.team.hk.sys.server.SysLoginInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    public MessageInfo login(@RequestBody SysUserInfo sysUserInfo, HttpServletRequest request) {
        MessageInfo messageInfo = new MessageInfo();
        SysUserInfo userInfo = sysLoginInfoService.login(sysUserInfo);
        if (Objects.nonNull(userInfo)) {
            // 获得sessionId
            String seid = request.getSession().getId();
            request.getSession().setAttribute("seid", seid);

            messageInfo.setCode(200);
            messageInfo.setMsg("登录成功！");
            stringRedisTemplate.opsForValue().set("userId", userInfo.getUserId().toString());
            return messageInfo;
        } else {
            messageInfo.setCode(500);
            messageInfo.setMsg("登录失败，账号或密码错误！");
            return messageInfo;
        }
    }

//    @ResponseBody
//    @RequestMapping(value = "/login1", method = RequestMethod.GET)
//    public MessageInfo login1(HttpServletRequest request) {
//        MessageInfo messageInfo = new MessageInfo();
//        SysUserInfo sysUserInfo = new SysUserInfo();
//        sysUserInfo.setUserName("admin");
//        sysUserInfo.setUserPassword("123456");
//        SysUserInfo userInfo = sysLoginInfoService.login(sysUserInfo);
//        if (Objects.nonNull(userInfo)) {
//            // 获得sessionId
//            String seid = request.getSession().getId();
//            request.getSession().setAttribute("seid", seid);
//            messageInfo.setCode(200);
//            messageInfo.setMsg("登录成功！");
//            stringRedisTemplate.opsForValue().set("userId", userInfo.getUserId().toString());
//            stringRedisTemplate.opsForValue().set("userName", userInfo.getUserName());
//            stringRedisTemplate.opsForValue().set("userRole", userInfo.getUserRole());
//            logger.debug(userInfo.getUserName() + " 登录系统");
//            return messageInfo;
//        } else {
//            messageInfo.setCode(500);
//            messageInfo.setMsg("登录失败，账号或密码错误！");
//            return messageInfo;
//        }
//    }

    /**
     * 退出
     *
     * @param request http请求
     * @return MessageInfo
     */
    @ResponseBody
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    @Override
    public MessageInfo loginOut(HttpServletRequest request) {
        request.getSession().removeAttribute("seid");
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode(200);
        messageInfo.setMsg("退出成功!");
        stringRedisTemplate.delete("userId");
        stringRedisTemplate.delete("userName");
        stringRedisTemplate.delete("userRole");
        logger.debug(stringRedisTemplate.opsForValue().get("userName") + " 退出系统");
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
