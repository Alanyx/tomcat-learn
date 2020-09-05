package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// 测试 filter 和 interceptor 的加载顺序
//@ComponentScan(basePackages = {"com.example.demo.designMode.*"})
@ComponentScan(basePackages = {"com.example.demo.common.*"})
//@ServletComponentScan
public class TomcatLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(TomcatLearnApplication.class, args);
    }

}
