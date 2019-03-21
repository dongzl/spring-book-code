package com.spring.boot.step.repository;

import com.spring.boot.step.model.AyUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dongzonglei
 * @description
 * @date 2019-03-21 10:07
 */
public interface AyUserRepository extends JpaRepository<AyUser, String> {


}
