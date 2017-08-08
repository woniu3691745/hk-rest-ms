package com.team.hk.annotation;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * Created by lidongliang on 2017/6/30.
 * 自定义注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Configuration
public @interface MyAnnotation {

}
