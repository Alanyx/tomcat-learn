package com.example.demo.common.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author Alan Yin
 * @date 2020/9/4
 */
@Service
public class BizService {

    public int divideZero() {
        return 1 / 0;
    }

    public String[] NPE1() {
        String nullStr = null;
        // NPE
        String[] strings = nullStr.split(",");
        return strings;
    }

    public String NPE2(String s) {
        if (StringUtils.isEmpty(s)) {
            throw new NullPointerException("NPE2:参数不能为空");
        }
        return s + "1";
    }
}
