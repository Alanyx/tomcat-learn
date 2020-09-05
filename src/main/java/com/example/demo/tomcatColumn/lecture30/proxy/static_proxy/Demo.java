package com.example.demo.tomcatColumn.lecture30.proxy.static_proxy;

/**
 * @author Alan Yin
 * @date 2020/9/4
 */

public class Demo {

    public static void main(String[] args) {
        IStudentDao studentDao = new StudentDaoProxy(new StudentDao());
        studentDao.save();
    }
}
