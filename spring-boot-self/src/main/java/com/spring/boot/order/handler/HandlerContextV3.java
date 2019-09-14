package com.spring.boot.order.handler;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author dongzonglei
 * @description
 * @date 2019-09-14 18:02
 */
@Component
public class HandlerContextV3 {

    public AbstractHandler getInstance(String type) {
        ApplicationContext applicationContext = null;
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(HandlerType.class);
        for (Map.Entry<String, Object> entry : beansWithAnnotation.entrySet()) {
            String handlerType = entry.getValue().getClass().getAnnotation(HandlerType.class).value();
            if (StringUtils.endsWithIgnoreCase(type, handlerType)) {
                return (AbstractHandler)entry.getValue();
            }
        }
        return null;
    }
}
