package com.spring.code.atomikos.user.repository;

import com.spring.code.atomikos.user.entity.UserInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dongzonglei
 * @description
 * @date 2020/8/8 下午4:43
 */
public interface IUserInfoDao extends JpaRepository<UserInfoDO, Long> {
    
}
