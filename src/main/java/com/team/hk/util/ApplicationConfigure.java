package com.team.hk.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by lidongliang on 2017/6/30.
 * Spring Boot 实现这个接口的类总是会被优先启动
 * 如果有多个CommandLineRunner接口实现类，那么可以通过注解@OrderInfoController
 */
@Component
public class ApplicationConfigure implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
    }
}
