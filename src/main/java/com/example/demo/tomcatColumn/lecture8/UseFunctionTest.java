package com.example.demo.tomcatColumn.lecture8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alan Yin
 * @date 2020/8/18
 */

public class UseFunctionTest {

    public static void main(String[] args) {
        t2();
    }

    static void t1() {
        String[] arr1 = new String[]{"a", "b", "c"};
        String[] arr2 = new String[arr1.length + 1];
        arr2[3] = "d";
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        List<String> list = Arrays.asList(arr2);
        System.out.println(list);
    }

    static void t2() {
        Map<String, Integer> stringMap = new HashMap<>();
        stringMap.put("a", 1);
        stringMap.put("b", 2);
        stringMap.put("c", 3);
        Integer[] results = new Integer[stringMap.size()];
        results = stringMap.values().toArray(results);
        System.out.println(Arrays.toString(results));
    }
}
