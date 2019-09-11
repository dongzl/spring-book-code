package com.spring.study;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author dongzonglei
 * @description
 * @date 2019-09-11 14:52
 */
@Configuration
@ComponentScan({"com.spring.study.module"})
public class HelloServiceAutoConfiguration {

}
