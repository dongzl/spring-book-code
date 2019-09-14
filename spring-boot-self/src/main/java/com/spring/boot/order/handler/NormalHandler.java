package com.spring.boot.order.handler;

import com.spring.boot.order.entity.OrderDTO;
import org.springframework.stereotype.Component;

/**
 * @author dongzonglei
 * @description
 * @date 2019-09-14 17:51
 */
@Component
@HandlerType("1")
public class NormalHandler extends AbstractHandler {

    @Override
    public String handle(OrderDTO dto) {
        return "处理普通订单";
    }
}
