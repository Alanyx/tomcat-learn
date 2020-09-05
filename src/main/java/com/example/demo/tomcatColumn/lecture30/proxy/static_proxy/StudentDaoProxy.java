package com.example.demo.tomcatColumn.lecture30.proxy.static_proxy;

/**
 * @author Alan Yin
 * @date 2020/9/4
 */

public class StudentDaoProxy implements IStudentDao{

    private StudentDao studentDao;

    public StudentDaoProxy(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    //在目标功能对象方法的前后加入事务控制
    @Override
    public void save() {
        System.out.println("before");
        studentDao.save();
        System.out.println("after");
    }
}
