package com.example.demo.common.response;

import lombok.Getter;

/**
 * @author Alan Yin
 * @date 2020/9/4
 */
@Getter
public class ResponseResults<T> {

    private int code = 200;
    private boolean success = true;
    private String message;
    private T result;

    public static ResponseResults ok(Object result) {
        ResponseResults results = new ResponseResults();
        results.setResult(result);
        return results;
    }

    public static ResponseResults error(int code, String message) {
        ResponseResults results = new ResponseResults();
        results.setCode(code);
        results.setMessage(message);
        return results;
    }

    public ResponseResults setCode(int code) {
        this.code = code;
        return this;
    }

    public ResponseResults setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public ResponseResults setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseResults setResult(T result) {
        this.result = result;
        return this;
    }
}
