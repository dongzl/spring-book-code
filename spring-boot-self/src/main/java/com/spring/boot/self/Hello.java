package com.spring.boot.self;

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

    @RequestMapping("/hello")
    public String hello() {
        return "Hello For Mac";
    }
}
