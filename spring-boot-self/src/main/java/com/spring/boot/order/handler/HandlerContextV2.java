package com.spring.boot.order.handler;

import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * @author dongzonglei
 * @description
 * @date 2019-09-14 18:02
 */
public class HandlerContextV2 {

    private Map<String, Class> handlerMap;

    public HandlerContextV2(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractHandler getInstance(String type) {
        Class clazz = handlerMap.get(type);
        if (clazz == null) {
            throw new IllegalArgumentException("not found handler for type :" + type);
        }
        ApplicationContext context = null;//new ApplicationContext();
        return (AbstractHandler)context.getBean(clazz);
    }
}
