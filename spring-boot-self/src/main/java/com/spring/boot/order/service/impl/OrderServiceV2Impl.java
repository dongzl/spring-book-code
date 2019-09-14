package com.spring.boot.order.service.impl;

import com.spring.boot.order.entity.OrderDTO;
import com.spring.boot.order.handler.AbstractHandler;
import com.spring.boot.order.handler.HandlerContext;
import com.spring.boot.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dongzonglei
 * @description
 * @date 2019-09-14 17:48
 */
@Service
public class OrderServiceV2Impl implements IOrderService {

    @Autowired
    private HandlerContext handlerContext;

    @Override
    public String handle(OrderDTO dto) {
        AbstractHandler handler = handlerContext.getInstance(dto.getType());
        return handler.handle(dto);
    }
}
