package com.example.demo.tomcatColumn.lecture8;

/**
 * @author Alan Yin
 * @date 2020/8/18
 */

public class MyCatalina {

    protected boolean useHook = true;

    protected Thread hook = null;

    /**
     * “关闭钩子”其实就是一个线程，JVM在停止之前会尝试执行这个线程的run方法
     */
    protected class CatalinaShutdownHook extends Thread {

        @Override
        public void run() {
            // doSomething: 比如关闭 jvm 之前刷新缓存到磁盘
        }
    }


    public void start() {

        // 创建并注册关闭钩子
        if (useHook) {
            hook = new CatalinaShutdownHook();
            Runtime.getRuntime().addShutdownHook(hook);
        }
    }

}
