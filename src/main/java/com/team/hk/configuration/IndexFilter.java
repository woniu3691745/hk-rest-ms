package com.team.hk.configuration;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by lidongliang on 2017/6/28.
 * Filter 过滤器
 */
@WebFilter(urlPatterns = "/*", filterName = "indexFilter")
public class IndexFilter implements Filter {

    private static Logger logger = Logger.getLogger(IndexFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("init IndexFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.debug("doFilter IndexFilter");
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
