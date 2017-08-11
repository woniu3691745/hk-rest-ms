package com.team.hk.configuration;

import com.team.hk.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by lidongliang on 2017/7/13.
 * 开始WebMvcConfig
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api/**");
    }

    /**
     * cors 跨域
     * Restful通过7个HTTP 谓词GET/POST/PUT/DELETE/PATCH/HEAD/OPTIONS 表示动作
     * @param registry registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "TRACE")
                .allowedOrigins("http://localhost:9527")
                .exposedHeaders("Set-Cookie")
                .allowCredentials(true)
                .maxAge(1800);
    }

    /**
     * 静态图片
     *
     * @param registry registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("classpath:/image/");
        super.addResourceHandlers(registry);
    }
}