package com.example.demo.tomcatColumn.lecture30.proxy.static_proxy;

/**
 * 步骤2：目标对象
 *
 * @author Alan Yin
 * @date 2020/9/4
 */

public class StudentDao implements IStudentDao {

    @Override
    public void save() {
        System.out.println("保存成功");
    }

}
