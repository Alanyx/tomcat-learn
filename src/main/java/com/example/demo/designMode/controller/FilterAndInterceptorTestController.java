package com.example.demo.designMode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 filter 和 interceptor 的方法执行顺序:
 * <p>
 * filter -> servlet service() -> dispatcher servlet -> interceptor preHandle
 * -> controller 业务代码 -> interceptor postHandle -> interceptor afterCompletion
 * -> filter
 *
 * @author Alan Yin
 * @date 2020/8/12
 */
@RestController
public class FilterAndInterceptorTestController {

    @RequestMapping("/test")
    public String test() {
        System.out.println("Controller 业务方法");
        return "success";
    }
}
