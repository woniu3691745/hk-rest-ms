package com.team.hk.configuration;

import com.team.hk.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lidongliang on 2017/7/13.
 * 开始WebMvcConfig
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/");
        registry.addInterceptor(new LoginInterceptor());
    }
}