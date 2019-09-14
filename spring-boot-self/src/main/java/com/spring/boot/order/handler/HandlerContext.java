package com.spring.boot.order.handler;

import java.util.Map;

/**
 * @author dongzonglei
 * @description
 * @date 2019-09-14 18:02
 */
public class HandlerContext {

    private Map<String, Class> handlerMap;

    public HandlerContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractHandler getInstance(String type) {
        Class clazz = handlerMap.get(type);
        if (clazz == null) {
            throw new IllegalArgumentException("not found handler for type :" + type);
        }
        //return (AbstractHandler) BeanTools.getBean();
        return null;
    }
}
