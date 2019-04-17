package com.spring.boot.step.service;

import com.spring.boot.step.model.AyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author dongzonglei
 * @description
 * @date 2019-03-21 10:11
 */
public interface IAyUserService {

    AyUser findById(String id);

    List<AyUser> findAll();

    AyUser save(AyUser user);

    void delete(String id);

    Page<AyUser> findAll(Pageable pageable);

    List<AyUser> findByName(String name);

    List<AyUser> findByNameLike(String name);

    List<AyUser> findByIdIn(Collection<String> ids);

    AyUser findByNameAndPassword(String name, String password);

    Future<List<AyUser>> findAsynAll();
}
