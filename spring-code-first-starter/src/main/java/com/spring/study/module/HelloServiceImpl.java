package com.spring.study.module;

import org.springframework.stereotype.Component;

/**
 * @author dongzonglei
 * @description
 * @date 2019-09-11 14:50
 */
@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return "Hello!!";
    }
}
