package com.example.demo.tomcatColumn.lecture24.demo2;

/**
 * @author Alan Yin
 * @date 2020/8/31
 */

public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader classLoader = new MyClassLoader();
        Class<?> clazz = Class.forName("Person", true, classLoader);
        Object obj = clazz.newInstance();

        System.out.println(obj);
        System.out.println(obj.getClass().getSimpleName());
        // 打印出自定义类加载器
        System.out.println(obj.getClass().getClassLoader());
    }
}
