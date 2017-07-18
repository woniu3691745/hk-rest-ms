package com.team.hk.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lidongliang on 2017/7/3.
 * cors 跨域
 * Restful通过7个HTTP 谓词GET/POST/PUT/DELETE/PATCH/HEAD/OPTIONS 表示动作
 */
@Configuration
@EnableWebMvc
public class Cors extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "TRACE")
                .allowedOrigins("*")
                .allowCredentials(true)
                .maxAge(60 * 60 * 10);
    }
}
