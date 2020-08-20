package com.example.demo.tomcatColumn.lecture14.java_nio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 回调类
 *
 * @author Alan Yin
 * @date 2020/6/19
 */

public class ReadHandler implements CompletionHandler<Integer, ByteBuffer> {

    public ReadHandler(AsynchronousSocketChannel result) {
    }

    /**
     * 读取到消息后的处理
     *
     * @param result
     * @param attachment
     */
    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        // attachment 就是数据，调用 flip 操作，就是把读的位置移动到最前面
        attachment.flip();
        // 读取数据
        // ...
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        // ...
    }
}
