package com.spring.code.self.circular.dependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * https://mp.weixin.qq.com/s/ziSZeWlU5me1WMKvoKobbQ
 * @author dongzonglei
 * @description
 * @date 2019-05-13 18:28
 */
public class Test {

    public static void main(String args[]) throws Exception {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-context.xml");
//        System.out.println(applicationContext.getBean("studentA"));

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-context2.xml");
//        System.out.println(applicationContext.getBean("studentA"));

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-context3.xml");
        System.out.println(applicationContext.getBean("studentA"));
    }
}
