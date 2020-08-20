package com.example.demo.designMode.controller;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注册 filter方式1： 使用配置类
 * 注册 filter方式2： 使用 @WebFilter (需要配合注解@ServletComponentScan扫描注册相应的Filter)
 *
 * @author Alan Yin
 * @date 2020/8/12
 */
@Configuration
public class FilterConfiguration {

    /**
     * 建议使用第一种方式注册:
     * <p>
     * 在一些特定的场景会有一些特定的需求(如过滤特定的链接)，我们可能需要自己实现注册，但是又需要Filter实例存在于Spring容器中，
     * 以便让其使用到Spring提供的众多服务(自动注入其他组件……)。所以需要取消Spring Boot的自动注入Filter。
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.addUrlPatterns("/*");
        registrationBean.setFilter(new LogFilter());
        return registrationBean;
    }

    /**
     * 第二种方式
     * @return
     */
//    @Bean
//    public LogFilter logFilter() {
//        return new LogFilter();
//    }

}
