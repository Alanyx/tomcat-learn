package com.example.demo.tomcatColumn.lecture17;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 模仿 tomcat 自定义任务队列 {@link org.apache.tomcat.util.threads.TaskQueue}
 *
 * @author Alan Yin
 * @date 2020/8/26
 */

public class MyTaskQueue extends LinkedBlockingQueue<Runnable> {

    /**
     * 省略 parent 初始化
     */
    private volatile MyThreadPoolExecutor parent = null;

    public MyTaskQueue() {
        super();
    }

    /**
     * 指定队列长度
     *
     * @param capacity
     */
    public MyTaskQueue(int capacity) {
        super(capacity);
    }

    /**
     * tomcat 自定义实现的不同之处
     *
     * @param command
     * @param timeout
     * @param unit
     * @return
     * @throws InterruptedException
     */
    public boolean force(Runnable command, int timeout, TimeUnit unit) throws InterruptedException {
        if (parent == null || parent.isShutdown()) {
            throw new RejectedExecutionException("Executor not running, can't force a command into the queue");
        }
        return super.offer(command, timeout, unit);
    }

    public boolean force(Runnable command) throws InterruptedException {
        if (parent == null || parent.isShutdown()) {
            throw new RejectedExecutionException("Executor not running, can't force a command into the queue");
        }
        return super.offer(command);
    }

    /**
     * 关键重写:使得 tomcat 在任务队列的长度无限制的情况下，让线程池有机会创建新的线程
     *
     * @param o
     * @return
     */
    @Override
    public boolean offer(Runnable o) {
        if (parent == null) {
            return super.offer(o);
        }

        // 1.如果已经到达了最大的线程数，让任务进入排队
        if (parent.getPoolSize() == parent.getMaximumPoolSize()) {
            return super.offer(o);
        }

        // 2.poolSize<= 当前线程数< maximumPoolSize

        // 2.1 还有空闲线程，无需创建新线程
        if (parent.getSubmittedCount() <= parent.getPoolSize()) {
            return super.offer(o);
        }
        // 2.2 没有空闲线程，创建新线程
        if (parent.getPoolSize() < parent.getMaximumPoolSize()) {
            return false;
        }

        // 3.默认任务都排队
        return super.offer(o);
    }
    
}
