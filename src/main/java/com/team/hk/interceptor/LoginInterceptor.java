package com.team.hk.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by lidongliang on 2017/7/13.
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    private static Logger logger = Logger.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o)
            throws Exception {
        HttpSession session = request.getSession();

//        response.setStatus(500);
//        response.setContentType("application/json;charset=utf-8");
//
//        Map mapInfo = new HashMap();
//        mapInfo.put("code", 500);
//        mapInfo.put("message", "用户没有登录！");
//        response.getWriter().write(JSONUtils.toJSONString(mapInfo));
//        logger.debug("用户没有登录！");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
