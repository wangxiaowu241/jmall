/**
 * $Id: ZuulGlobalException.java,v 1.0 2019/1/16 11:14 AM wangxiaoteng
 *
 * @Copyright (c) 2019/1/16, Lianjia Group All Rights Reserved.
 */
package com.xt.open.jmall.zuul.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * zuul的全局异常处理器
 *
 * @author wangxiaoteng
 * @version $Id: ZuulGlobalException.java,v 1.0 2019/1/16 11:14 AM wangxiaoteng
 * @date 2019/1/16 下午11:14 AM
 */
@RestControllerAdvice
public class ZuulGlobalException {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity handleIllegalArgumentException(IllegalArgumentException exception) {

        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleAllException(Exception e) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseEntity handleNoHandlerFoundException(NoHandlerFoundException noHandlerFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(noHandlerFoundException.getMessage());
    }
}
