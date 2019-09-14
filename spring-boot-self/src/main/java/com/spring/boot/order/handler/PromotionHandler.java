package com.spring.boot.order.handler;

import com.spring.boot.order.entity.OrderDTO;
import org.springframework.stereotype.Component;

/**
 * @author dongzonglei
 * @description
 * @date 2019-09-14 17:51
 */
@Component
@HandlerType("3")
public class PromotionHandler extends AbstractHandler {

    @Override
    public String handle(OrderDTO dto) {
        return "处理促销订单";
    }
}
