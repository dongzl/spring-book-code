package com.spring.boot.order.handler;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author dongzonglei
 * @description
 * @date 2019-09-14 17:56
 */
@Component
@SuppressWarnings("unchecked")
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private static final String HANDLER_PACKAGE = "com.spring.boot.order.handler";

    /**
     * 扫描 @HandlerType，初始化 HandlerContext，将其注册到 Spring 容器
     *
     * @param beanFactory bean 工厂
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Class> handleMap = Maps.newHashMapWithExpectedSize(3);
//        ClassScaner.scan(HANDLER_PACKAGE, HandlerType.class).forEach(clazz -> {
//            // 获取注解中的类型值
//            String type = clazz.getAnnotation(HandlerType.class).value();
//            // 将注解中的 key 做为值，将其注册到 Spring 容器中
//            handleMap.put(type, clazz);
//        });

        ApplicationContext applicationContext = null;
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(HandlerType.class);
        for (Map.Entry<String, Object> entry : beansWithAnnotation.entrySet()) {
            String type = entry.getValue().getClass().getAnnotation(HandlerType.class).value();
            handleMap.put(type, entry.getValue().getClass());
        }
        HandlerContext context = new HandlerContext(handleMap);
        beanFactory.registerSingleton(HandlerContext.class.getName(), context);
    }
}
