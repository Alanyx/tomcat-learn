package com.example.demo.tomcatColumn.lecture4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用注解的方式部署 Servlet
 *
 * @author Alan Yin
 * @date 2020/5/7
 */

/**
 * @WebServlet
 * 第一层意思是 AnnotationServlet 这个 Java 类是一个 Servlet
 * 第二层意思是这个 Servlet 对应的 URL 路径是 myAnnotationServlet
 */
@WebServlet("/myAnnotationServlet")
public class AnnotationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AnnotationServlet 在处理 get 请求...");
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        writer.println("<h2>My Servlet!<h2>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AnnotationServlet 在处理 post 请求...");
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        writer.println("<h2>My Servlet 2!<h2>");
    }

}