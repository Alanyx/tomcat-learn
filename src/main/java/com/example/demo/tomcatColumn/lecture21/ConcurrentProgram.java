package com.example.demo.tomcatColumn.lecture21;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 高效并发编程
 *
 * @author Alan Yin
 * @date 2020/7/13
 */

public class ConcurrentProgram {

    // 1.使用细粒度锁(不要在方法上直接使用 Synchronized )

    private final Object lock = new Object();

    public void test1() {
        synchronized (lock) {
            // do something
        }
    }

    // 2.使用原子类和 CAS

    private AtomicLong count = new AtomicLong(0);

    public void test2() throws InterruptedException {
        while (true) {
            if (!count.compareAndSet(1, 2)) {
//            if (!count.compareAndSet(0, 2)) {
                System.out.println("count is not 2,continue try");
                Thread.sleep(3000);
                continue;
            }
            boolean isEq = count.get() == 2;
            if (isEq) {
                System.out.println("count is 2,end");
                break;
            }
        }
    }

    // 3.使用并发容器:如 CopyOnWriteArrayList 适用于读多写少的场景

    private List<Object> list = new CopyOnWriteArrayList<>();

    // 4.使用 volatile 关键字:其他线程可见

    public static void main(String[] args) throws InterruptedException {
        ConcurrentProgram cp = new ConcurrentProgram();
        cp.test2();
    }

}
