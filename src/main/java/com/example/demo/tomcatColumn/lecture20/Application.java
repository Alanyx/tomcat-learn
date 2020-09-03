package com.example.demo.tomcatColumn.lecture20;

/**
 * @author Alan Yin
 * @date 2020/8/27
 */

public class Application {

    public static void main(String[] args) {
        MySynchronizedStack<Person> stack = new MySynchronizedStack<>(4, 10);
        for (int i = 0; i < 12; i++) {
            System.out.println(stack.push(new Person("name-" + i, i)));
        }

        for (int i = 0; i < 12; i++) {
            System.out.println(stack.pop());
        }

    }
}
