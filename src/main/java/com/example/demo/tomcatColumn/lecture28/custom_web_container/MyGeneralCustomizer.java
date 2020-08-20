package com.example.demo.tomcatColumn.lecture28.custom_web_container;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

/**
 * 定制Web容器方式1:
 * <p>
 * 通过通用的Web容器工厂ConfigurableServletWebServerFactory，来定制一些Web容器通用的参数
 *
 * @author Alan Yin
 * @date 2020/7/20
 */
@Component
public class MyGeneralCustomizer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setPort(8081);
        factory.setContextPath("/test28");
    }
}
