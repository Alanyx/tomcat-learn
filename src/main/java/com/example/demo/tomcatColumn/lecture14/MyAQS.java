package com.example.demo.tomcatColumn.lecture14;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 参考 Tomcat 中 LimitLatch 对 AbstractQueuedSynchronizer 的使用
 *
 * @author Alan Yin
 * @date 2020/8/20
 */

public class MyAQS extends AbstractQueuedSynchronizer {

    private final AtomicLong count;
    private volatile long limit;
    private volatile boolean released = false;


    public MyAQS(long limit) {
        this.count = new AtomicLong(0);
        this.limit = limit;
    }

    @Override
    protected int tryAcquireShared(int arg) {
        long newCount = count.incrementAndGet();
        if (!released && newCount > limit) {
            count.decrementAndGet();
            return -1;
        }
        return 1;
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        count.decrementAndGet();
        return true;
    }

}
