package com.example.demo.tomcatColumn.lecture32;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Alan Yin
 * @date 2020/5/27
 */

public class SessionDemo {

    public void test(HttpServletRequest request){
        HttpSession session = request.getSession();

        //
        HttpSession session2 = request.getSession(true);

    }

}
