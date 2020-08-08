package com.spring.code.atomikos.order.entity;

/**
 * @author dongzonglei
 * @description
 * @date 2020/8/8 下午4:42
 */
public class OrderInfoDO {
    
    private Long orderId;
    
    private Long userId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
