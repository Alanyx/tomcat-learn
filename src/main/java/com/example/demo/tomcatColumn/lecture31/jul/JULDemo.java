package com.example.demo.tomcatColumn.lecture31.jul;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java的日志包 (java.util.logging) 演示
 * @author Alan Yin
 * @date 2020/9/5
 */

public class JULDemo {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("com.example.demo.tomcatColumn");
        logger.setLevel(Level.FINE);
        logger.setUseParentHandlers(false);

        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.FINE);
        logger.addHandler(handler);
        logger.info("start log");
    }
}
