package com.example.demo.tomcatColumn.lecture24.demo1;

/**
 * @author Alan Yin
 * @date 2020/8/31
 */

public class ClassDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("com.example.demo.tomcatColumn.lecture24.Person");
        System.out.println(clazz.getClass().getMethods());
    }
}
