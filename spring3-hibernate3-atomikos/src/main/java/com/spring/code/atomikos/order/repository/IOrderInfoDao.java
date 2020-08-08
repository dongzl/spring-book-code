package com.spring.code.atomikos.order.repository;

import com.spring.code.atomikos.order.entity.OrderInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dongzonglei
 * @description
 * @date 2020/8/8 下午4:44
 */
public interface IOrderInfoDao extends JpaRepository<OrderInfoDO, Long> {
    
}
