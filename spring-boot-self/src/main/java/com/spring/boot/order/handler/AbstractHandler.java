package com.spring.boot.order.handler;

import com.spring.boot.order.entity.OrderDTO;

/**
 * @author dongzonglei
 * @description
 * @date 2019-09-14 17:50
 */
public abstract class AbstractHandler {

    public abstract String handle(OrderDTO dto);
}
