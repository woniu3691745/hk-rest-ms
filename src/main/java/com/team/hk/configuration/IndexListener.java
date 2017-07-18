package com.team.hk.configuration;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by lidongliang on 2017/6/28.
 * Listener 监听
 */
public class IndexListener implements ServletContextListener {

    private static Logger logger = Logger.getLogger(IndexListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.debug("IndexListener contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
