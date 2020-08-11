package com.spring.code.atomikos.order.repository;

import com.spring.code.atomikos.order.entity.OrderInfoDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dongzonglei
 * @description
 * @date 2020/8/8 下午4:44
 */
@Repository
public interface IOrderInfoDao extends CrudRepository<OrderInfoDO, Long> {

}
