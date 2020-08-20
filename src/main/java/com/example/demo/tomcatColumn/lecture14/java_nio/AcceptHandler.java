package com.example.demo.tomcatColumn.lecture14.java_nio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * AcceptHandler类实现了CompletionHandler接口的completed方法。它还有两个模板参数，第一个是异步通道，第二个就是Nio2Server本身
 *
 * @author Alan Yin
 * @date 2020/6/19
 */

public class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Nio2Server> {

    /**
     * 具体处理连接请求的就是completed方法，它有两个参数：第一个是异步通道，第二个就是上面传入的NioServer对象
     *
     * @param result
     * @param attachment
     */
    @Override
    public void completed(AsynchronousSocketChannel result, Nio2Server attachment) {
        //调用accept方法继续接收其他客户端的请求
//        attachment.assc.accept(attachment, this);

        // 1.先分配好 Buffer,告诉内核，数据拷贝到哪里去
        ByteBuffer buf = ByteBuffer.allocate(1024);

        // 2.调用read 函数读取数据，除了把 buf 作为参数传入，还传入读回调类
//        channel.read(buf, buf, new ReadHandler(result));
    }

    @Override
    public void failed(Throwable exc, Nio2Server attachment) {

    }
}
