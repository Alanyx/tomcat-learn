package com.example.demo.tomcatColumn.lecture30.proxy.dynamic_proxy;

import com.example.demo.tomcatColumn.lecture30.proxy.static_proxy.IStudentDao;
import com.example.demo.tomcatColumn.lecture30.proxy.static_proxy.StudentDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Alan Yin
 * @date 2020/9/4
 */

public class Demo {

    public static void main(String[] args) {
        // 创建目标对象
        IStudentDao studentDao = new StudentDao();

        // 创建 InvocationHandler
        InvocationHandler handler = new MyInvocationHandler(studentDao);

        // 创建代理对象
        IStudentDao studentDaoProxy = (IStudentDao) Proxy.newProxyInstance(
                studentDao.getClass().getClassLoader(),
                studentDao.getClass().getInterfaces(),
                handler);

        // 动态代理对象的方法
        studentDaoProxy.save();
    }
}
