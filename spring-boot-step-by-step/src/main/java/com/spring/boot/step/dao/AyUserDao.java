package com.spring.boot.step.dao;

import com.spring.boot.step.model.AyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-16 10:58
 */
@Mapper
public interface AyUserDao {

    AyUser findByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
