package com.team.hk;


import com.team.hk.configuration.IndexFilter;
import com.team.hk.configuration.IndexListener;
import com.team.hk.configuration.IndexServlet;
import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication // same as @configuration @EnableAutoConfiguration @ComponentScan
@ServletComponentScan
@MapperScan("com.team.hk.*.mapper")
public class HkRestMsApplication {

    private static Logger logger = Logger.getLogger(HkRestMsApplication.class);

    /**
     * 启动类
     */
    public static void main(String... args) throws ClassNotFoundException {
//        SpringApplication.run(HkRestMsApplication.class, args);
//        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication app = new SpringApplication(HkRestMsApplication.class);
//        app.addListeners(new TestSysFunction()); // 调用listener
        app.run();
    }

    /**
     * Servlet
     *
     * @return 注册的servlet
     */
    @Bean
    public ServletRegistrationBean indexServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new IndexServlet());
        registration.addUrlMappings("/myServlet");
        return registration;
    }

    /**
     * Filter
     *
     * @return 注册的filter
     */
    @Bean
    public FilterRegistrationBean indexFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new IndexFilter());
        registration.addUrlPatterns("/");
        return registration;
    }

    /**
     * listener
     *
     * @return 注册的listener
     */
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new IndexListener());
        return servletListenerRegistrationBean;
    }

}
