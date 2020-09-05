package com.example.demo.common.controller;

import com.example.demo.common.response.ResponseResults;
import com.example.demo.common.service.BizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alan Yin
 * @date 2020/8/21
 */
@RestController
public class CommonController {

    @Autowired
    private BizService bizService;

    @RequestMapping("/h")
    public String hello() {
        System.out.println("request success");
        return "hello";
    }

    /**
     * 除 0 异常(被全局捕获)
     *
     * @return
     */
    @RequestMapping("/e1")
    public ResponseResults exception1() {
        return ResponseResults.ok(bizService.divideZero());
    }

    /**
     * 空指针异常(被全局捕获)
     *
     * @return
     */
    @RequestMapping("/e2")
    public ResponseResults exception2() {
        return ResponseResults.ok(bizService.NPE1());
    }

    /**
     * 空指针异常(被全局捕获)
     *
     * @return
     */
    @RequestMapping("/e3")
    public ResponseResults exception3() {
        return ResponseResults.ok(bizService.NPE2(""));
    }

    /**
     * 正常返回
     *
     * @return
     */
    @RequestMapping("/e4")
    public ResponseResults exception4() {
        return ResponseResults.ok(bizService.NPE2("param"));
    }

    /**
     * 正常返回
     *
     * @return
     */
    @RequestMapping("/e5")
    public ResponseResults exception5() {
        String s = "default";
        try {
            s = bizService.NPE2(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseResults.ok(s);
    }

}
