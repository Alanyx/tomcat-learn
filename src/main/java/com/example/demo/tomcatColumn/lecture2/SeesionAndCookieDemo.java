package com.example.demo.tomcatColumn.lecture2;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Alan Yin
 * @date 2020/8/10
 */

public class SeesionAndCookieDemo {

    private void createSession(HttpServletRequest req) {
        HttpSession session = req.getSession();
    }

    private void createCookie(HttpServletRequest req) {
        Cookie cookie = new Cookie("name", "value");
        cookie.setPath("/");
        cookie.setDomain("www.test.com");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(1000 * 3600);

        // 获取浏览器 cookies（可见 cookie 可以不只一个）
        Cookie[] cookies = req.getCookies();
        StringBuffer sb = new StringBuffer();
    }

}
