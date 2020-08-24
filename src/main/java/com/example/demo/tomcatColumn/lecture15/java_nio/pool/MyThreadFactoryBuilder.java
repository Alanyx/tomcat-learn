package com.example.demo.tomcatColumn.lecture15.java_nio.pool;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Alan Yin
 * @date 2020/8/24
 */

public class MyThreadFactoryBuilder {

    /**
     * 原子操作保证每个线程都有唯一的
     */
    private static final AtomicLong nextId = new AtomicLong(1);

    private String prefix;

    private String poolName;

    private boolean daemon;

    private ThreadGroup threadGroup;

    public MyThreadFactoryBuilder() {
        this.daemon = false;
        this.poolName = "default_pool";
        threadGroup = (System.getSecurityManager() == null) ?
                Thread.currentThread().getThreadGroup() : System.getSecurityManager().getThreadGroup();
    }

    public MyThreadFactoryBuilder setThreadGroup(ThreadGroup threadGroup) {
        if (threadGroup != null) {
            this.threadGroup = threadGroup;
        }
        return this;
    }

    public MyThreadFactoryBuilder setDaemon(boolean daemon) {
        this.daemon = daemon;
        return this;
    }

    public MyThreadFactoryBuilder setPoolName(String poolName) {
        if (StringUtils.isEmpty(poolName)) {
            return this;
        }
        this.poolName = poolName;
        return this;
    }

    public ThreadFactory build() {
        prefix = poolName + "-";
        return r -> {
            Thread thread = new Thread(threadGroup, r, prefix + nextId.getAndIncrement());
            thread.setDaemon(daemon);
            return thread;
        };
    }

}
