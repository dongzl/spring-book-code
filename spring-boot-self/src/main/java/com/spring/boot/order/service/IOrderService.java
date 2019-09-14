package com.spring.boot.order.service;

import com.spring.boot.order.entity.OrderDTO;

/**
 * @author dongzonglei
 * @description
 * @date 2019-09-14 17:43
 */
public interface IOrderService {

    /**
     * 根据订单的不同类型进行不同的处理
     * @param dto 订单实体
     * @return 为了简单，返回字符串
     */
    String handle(OrderDTO dto);
}
