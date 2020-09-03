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
                    System.out.println("begin");

                    // 处理超时
                    // 然异步Servlet允许用更长的时间来处理请求，但是也有超时限制的，默认是30秒，如果 30秒内请求还没处理完，Tomcat会触发超时机制，向浏览器返回超时错误，
                    // 如果这个时候你的Web应用再 调用ctx.complete方法，会得到一个 IllegalStateException异常。
                    // Thread.sleep(40000);

                    // 正常处理
                    Thread.sleep(1000);
                    ctx.getResponse().getWriter().println("Handling Async Servlet");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end");
                //3.异步 servlet 处理完调用异步上下文的 complete 方法
                ctx.complete();
            }
        });
    }
}
