package com.team.hk.annotation;

import java.lang.annotation.*;

/**
 * Created by lidongliang on 2017/6/30.
 * 自定义注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface DefinedAnnotation {

    String[] value() default {" this is default ."};

    String say() default "Hi";

}
