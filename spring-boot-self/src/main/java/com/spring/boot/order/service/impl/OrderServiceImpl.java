package com.spring.boot.order.service.impl;

import com.spring.boot.order.entity.OrderDTO;
import com.spring.boot.order.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * @author dongzonglei
 * @description
 * @date 2019-09-14 17:45
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Override
    public String handle(OrderDTO dto) {
        String type = dto.getType();
        if ("1".equals(type)) {
            return "处理普通订单";
        } else if ("2".equals(type)) {
            return "处理团购订单";
        } else if ("3".equals(type)) {
            return "处理促销订单";
        }
        return null;
    }
}
