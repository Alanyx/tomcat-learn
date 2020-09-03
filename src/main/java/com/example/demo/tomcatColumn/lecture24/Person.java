package com.example.demo.tomcatColumn.lecture24;

/**
 * 准备一个 class 文件，编译后放到指定目录下(如 /Users/yinxing/Desktop/Person.class)
 * @author Alan Yin
 * @date 2020/8/27
 */
public class Person {

    private String name;

    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
