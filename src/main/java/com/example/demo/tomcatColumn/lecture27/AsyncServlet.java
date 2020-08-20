package com.example.demo.tomcatColumn.lecture27;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 异步的 Servlet
 *
 * @author Alan Yin
 * @date 2020/7/20
 */
@WebServlet(urlPatterns = {"/async"}, asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    /**
     * web 应用的线程池，用于处理异步的 Servlet
     */
    ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) {
        // 1.调用 startAsync 或者异步上下文
        final AsyncContext ctx = request.startAsync();

        // 2.使用线程池执行耗时操作
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    ctx.getResponse().getWriter().println("Handling Async Servlet");
                } catch (IOException e) {

                }
                //3.异步 servlet 处理完调用异步上下文的 complete 方法
                ctx.complete();
            }
        });
    }
}
