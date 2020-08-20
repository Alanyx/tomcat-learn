package com.example.demo.tomcatColumn.lecture28.servlet_registration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 方式2：Spring Boot也提供了ServletRegistrationBean、FilterRegistrationBean和 ServletListenerRegistrationBean
 * 这三个类分别用来注册Servlet、Filter、Listener。
 *
 * @author Alan Yin
 * @date 2020/7/20
 */
@Configuration
public class ServletRegistrationConfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new MyServlet(), "/test28");
    }

}
