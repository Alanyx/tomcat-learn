package com.example.demo.tomcatColumn.lecture28.servlet_registration;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 方式3:动态注册
 * <p>
 * 创建一个类去实现前面提到的ServletContextInitializer接口，并把它注册为一个Bean，Spring Boot会负责调用这个接口的onStartup方法。
 *
 * @author Alan Yin
 * @date 2020/7/20
 */
@Component
public class MyServletRegister implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // servlet 3.0 规范新的 api
        ServletRegistration myServlet = servletContext.addServlet("MyServlet", MyServlet.class);

        myServlet.addMapping("/test28");
        myServlet.setInitParameter("name", "hello myServlet");
    }
}
