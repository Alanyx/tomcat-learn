package com.example.demo.tomcatColumn.lecture20;

/**
 * 自定义同步的对象池实现(参照 Tomcat @link{org.apache.tomcat.util.collections.SynchronizedStack})
 *
 * @author Alan Yin
 * @date 2020/7/13
 */

public class MySynchronizedStack<T> {

    /**
     * 默认的大小和限制
     */
    private static final int DEFAULT_SIZE = 128;
    private static final int DEFAULT_LIMIT = -1;

    private int size;
    private final int limit;

    /**
     * 指向在 stack 中下一个可用的对象
     */
    private int index;

    /**
     * 对象池关键实现：此处是数组(相比于链表更节省内存)
     */
    private Object[] stack;

    public MySynchronizedStack() {
        this(DEFAULT_SIZE, DEFAULT_LIMIT);
    }

    public MySynchronizedStack(int size, int limit) {
        if (limit > -1 && size > limit) {
            this.size = limit;
        } else {
            this.size = size;
        }
        this.limit = limit;
        stack = new Object[size];
    }

    /**
     * 归还对象
     *
     * @param obj
     * @return
     */
    public synchronized boolean push(T obj) {
        index++;
        if (index == size) {
            if (limit == -1 || size < limit) {
                // 扩展对象池大小
                expand();
            } else {
                // 已经到达最大，不能再扩展更大
                index--;
                return false;
            }
        }
        stack[index] = obj;
        return true;
    }

    /**
     * 取对象
     *
     * @return
     */
    public synchronized T pop() {
        // 对象池用完了
        if (index == -1) {
            return null;
        }
        T result = (T) stack[index];
        stack[index--] = null;
        return result;
    }

    /**
     * 清空同步栈
     */
    public synchronized void clear() {
        if (index > -1) {
            for (int i = 0; i < index + 1; i++) {
                stack[i] = null;
            }
        }
        index = -1;
    }

    /**
     * 扩容(两倍大小的方式扩容)
     */
    private void expand() {
        int newSize = size * 2;
        if (limit != -1 && newSize > limit) {
            newSize = limit;
        }
        Object[] newStack = new Object[newSize];
        System.arraycopy(stack, 0, newStack, 0, size);
        // This is the only point where garbage is created by throwing away the
        // old array. Note it is only the array, not the contents, that becomes garbage.
        stack = newStack;
        size = newSize;
    }
}
