package com.example.demo.common.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alan Yin
 * @date 2020/8/21
 */
@RestController
public class CommonController {

    @RequestMapping("/h")
    public String hello() {
        System.out.println("request success");
        return "hello";
    }
}
