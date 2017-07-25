package com.team.hk.interceptor;

import com.alibaba.druid.support.json.JSONUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lidongliang on 2017/7/13.
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    private static Logger logger = Logger.getLogger(LoginInterceptor.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o)
            throws Exception {

        // 无需登录，允许访问的地址
        String[] allowUrls = new String[]{"/toLogin", "/login"};

        // 获取请求地址
        String addRessUrl = request.getRequestURL().toString();

        // 获得登陆用户session
        Object seid = request.getSession().getAttribute("seid");

        for (String strUrl : allowUrls) {
            if (addRessUrl.contains(strUrl)) {
                return true;
            }
        }
        if (seid == null) {
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(500);

            Map<String, String> map = new HashMap<>();
            map.put("code", "500");
            map.put("msg", "您尚未登录！");
            response.getWriter().write(JSONUtils.toJSONString(map));

            logger.info(JSONUtils.toJSONString(map));
//            String url = "/api/login";
//            response.sendRedirect(url);
            return false;
        } else {
            return true;
        }

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
