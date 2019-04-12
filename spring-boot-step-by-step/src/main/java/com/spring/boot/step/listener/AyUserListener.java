package com.spring.boot.step.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-12 17:29
 */
@WebListener
public class AyUserListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext初始化上下文");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext上下文销毁");
    }
}
