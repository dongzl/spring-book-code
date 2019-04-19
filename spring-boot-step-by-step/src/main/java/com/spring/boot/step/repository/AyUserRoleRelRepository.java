package com.spring.boot.step.repository;

import com.spring.boot.step.model.AyUserRoleRel;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-19 14:41
 */
public interface AyUserRoleRelRepository extends JpaRepository<AyUserRoleRel, String> {

    List<AyUserRoleRel> findByUserId(@Param("userId")String userId);
}
