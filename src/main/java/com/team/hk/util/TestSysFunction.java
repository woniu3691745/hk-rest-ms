package com.team.hk.util;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Created by lidongliang on 2017/6/27.
 * Listener
 */
public class TestSysFunction implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        ConfigurableEnvironment abc = applicationEnvironmentPreparedEvent.getEnvironment();
        System.out.println(abc.getSystemEnvironment());
    }
}
