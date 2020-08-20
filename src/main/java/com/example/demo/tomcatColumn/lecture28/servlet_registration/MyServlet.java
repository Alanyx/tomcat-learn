package com.example.demo.tomcatColumn.lecture28.servlet_registration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * 注册 Servlet 的三种方式之方式1：
 * 在Web应用的入口类上加上@ServletComponentScan， 并且在Servlet类上加上@WebServlet，
 * 这样 SpringBoot会负责将Servlet注册到内嵌的Tomcat中。
 *
 * @author Alan Yin
 * @date 2020/7/20
 */
@WebServlet("/test28")
public class MyServlet extends HttpServlet {
}
