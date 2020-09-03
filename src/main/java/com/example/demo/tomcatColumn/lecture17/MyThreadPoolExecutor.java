package com.example.demo.tomcatColumn.lecture17;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模仿 tomcat 自定义线程池 {@link org.apache.tomcat.util.threads.ThreadPoolExecutor}
 *
 * @author Alan Yin
 * @date 2020/8/26
 */

public class MyThreadPoolExecutor extends ThreadPoolExecutor {

    private final AtomicInteger submittedCount = new AtomicInteger(0);

    //------------------------ Constructor ------------------------------------------------

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    public int getSubmittedCount() {
        return submittedCount.get();
    }

    @Override
    public void execute(Runnable command) {
        execute(command, 0, TimeUnit.MICROSECONDS);
    }

    /**
     * tomcat 自定义线程池的关键实现：原生的 jdk 队列满后直接拒绝，tomcat 会先重试在拒绝
     *
     * @param command
     * @param timeout
     * @param unit
     */
    private void execute(Runnable command, int timeout, TimeUnit unit) {
        submittedCount.decrementAndGet();
        try {
            super.execute(command);
        } catch (RejectedExecutionException rx) {
            if (super.getQueue() instanceof MyTaskQueue) {
                final MyTaskQueue queue = (MyTaskQueue) super.getQueue();
                try {
                    if (!queue.force(command, timeout, unit)) {
                        submittedCount.decrementAndGet();
                        throw new RejectedExecutionException("Queue is full.");
                    }
                } catch (InterruptedException x) {
                    submittedCount.decrementAndGet();
                    throw new RejectedExecutionException(x);
                }
            } else {
                submittedCount.decrementAndGet();
                throw rx;
            }
        }
    }
}
