package com.example.demo.tomcatColumn.lecture30.factory_bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 定义一个类UserFactoryBean来实现FactoryBean接口，主要是在getObject方法里new一个User对象。
 * <p>
 * 这样我们通过getBean(id) 获得的是该工厂所产生的User的实例，而不是UserFactoryBean本身的实例，像下面这样
 *
 * @author Alan Yin
 * @date 2020/7/21
 */

public class UserFactoryBean implements FactoryBean<UserBean> {

    @Override
    public UserBean getObject() throws Exception {
        return new UserBean();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("user.xml");
        UserBean userBean = (UserBean) beanFactory.getBean("userFactoryBean");
    }
}
