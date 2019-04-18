package com.spring.boot.step.exception;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-18 18:42
 */
public class BusinessException extends RuntimeException {

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
}
