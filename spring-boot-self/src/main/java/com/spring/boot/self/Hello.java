package com.spring.boot.self;

import com.spring.study.module.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dongzonglei
 * @description
 * @date 2019-03-19 15:04
 */
@RestController
@EnableAutoConfiguration
public class Hello {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello() {
        return helloService.sayHello();
        //return "Hello For Mac";
    }
}
