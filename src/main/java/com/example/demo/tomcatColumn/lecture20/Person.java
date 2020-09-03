package com.example.demo.tomcatColumn.lecture20;

import lombok.Data;

/**
 * @author Alan Yin
 * @date 2020/8/27
 */
@Data
public class Person {

    private String name;

    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
