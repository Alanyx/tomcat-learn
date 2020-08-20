package com.example.demo.tomcatColumn.lecture4;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义 servlet
 *
 * @author Alan Yin
 * @date 2020/5/7
 */

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet 在处理 get 请求...");
        PrintWriter writer =  resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        writer.println("<h2>My Servlet!<h2>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet 在处理 post 请求...");
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        writer.println("<h2>My Servlet 2!<h2>");
    }

}
