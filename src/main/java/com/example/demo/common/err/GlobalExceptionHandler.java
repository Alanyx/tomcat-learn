package com.example.demo.common.err;

import com.example.demo.common.response.ResponseResults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author Alan Yin
 * @date 2020/9/4
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResponseResults handleError(NullPointerException e) {
        log.error("NullPointerException,cause by:{}", e);
        String msg = e.getMessage();
        return ResponseResults.error(HttpStatus.BAD_REQUEST.value(), msg);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseResults handleError(Throwable e) {
        log.error("Internal Server Error:{}", e);
        String msg = e.getMessage();
        return ResponseResults.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

}
