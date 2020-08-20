package com.example.demo.tomcatColumn.lecture14.java_nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用Java的 NIO.2 API来编写一个服务端程序
 *
 * @author Alan Yin
 * @date 2020/6/19
 */

public class Nio2Server {

    void listen() throws IOException {
        // 1.创建一个线程池：用来执行来自内核的回调请求
        ExecutorService es = Executors.newCachedThreadPool();

        // 2.创建一个异步通道群组，绑定一个线程池
        AsynchronousChannelGroup acg = AsynchronousChannelGroup.withCachedThreadPool(es, 1);

        // 3.创建服务端异步通道
        AsynchronousServerSocketChannel assc = AsynchronousServerSocketChannel.open(acg);

        // 4.绑定监听端口
        assc.bind(new InetSocketAddress(8080));

        // 5.监听连接，传入回调类处理连接请求
         assc.accept(this, new AcceptHandler());
    }
}
