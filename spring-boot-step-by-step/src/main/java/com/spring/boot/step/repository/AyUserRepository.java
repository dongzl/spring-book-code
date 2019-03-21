package com.spring.boot.step.repository;

import com.spring.boot.step.model.AyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * @author dongzonglei
 * @description
 * @date 2019-03-21 10:07
 */
public interface AyUserRepository extends JpaRepository<AyUser, String> {

    List<AyUser> findByName(String name);

    List<AyUser> findByNameLike(String name);

    List<AyUser> findByIdIn(Collection<String> ids);
}
