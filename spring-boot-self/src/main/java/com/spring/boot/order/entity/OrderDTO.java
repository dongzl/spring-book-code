package com.spring.boot.order.entity;

import java.math.BigDecimal;

/**
 * @author dongzonglei
 * @description
 * @date 2019-09-14 17:42
 */
public class OrderDTO {

    private String code;

    private BigDecimal price;

    /**
     * 订单类型：
     * 1：普通订单
     * 2：团购订单
     * 3：促销订单
     */
    private String type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
