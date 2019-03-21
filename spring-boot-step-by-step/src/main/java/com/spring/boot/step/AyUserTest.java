package com.spring.boot.step;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dongzonglei
 * @description
 * @date 2019-03-20 18:43
 */
@RestController
@EnableAutoConfiguration
public class AyUserTest {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello For Mac";
    }

}
