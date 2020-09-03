package com.example.demo.tomcatColumn.lecture17;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Alan Yin
 * @date 2020/8/26
 */

public class Application {

    private static final AtomicLong count = new AtomicLong(0);

    public static void main(String[] args) {
        MyThreadPoolExecutor executor = new MyThreadPoolExecutor(10,
                20,
                60,
                TimeUnit.SECONDS,
                new MyTaskQueue(1000));

        for (int i = 0; i < 50; i++) {
            executor.execute(new MyTask());
        }

        List<Runnable> tasks = Arrays.asList(
                () -> System.out.println("task1"),
                () -> System.out.println("task2"),
                () -> System.out.println("task3"));
        tasks.parallelStream().forEach(executor::submit);

        System.out.println("main end");
    }

    private static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                count.incrementAndGet();
                System.out.println("MyTask-" + count.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
