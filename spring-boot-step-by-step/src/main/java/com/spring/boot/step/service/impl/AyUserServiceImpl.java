package com.spring.boot.step.service.impl;

import com.spring.boot.step.model.AyUser;
import com.spring.boot.step.repository.AyUserRepository;
import com.spring.boot.step.service.IAyUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author dongzonglei
 * @description
 * @date 2019-03-21 10:11
 */
@Service
@Transactional
public class AyUserServiceImpl implements IAyUserService {

    @Resource
    private AyUserRepository ayUserRepository;

    @Override
    public AyUser findById(String id) {
        return ayUserRepository.findById(id).get();
    }

    @Override
    public List<AyUser> findAll() {
        return ayUserRepository.findAll();
    }

    @Override
    @Transactional
    public AyUser save(AyUser user) {
        return ayUserRepository.save(user);
    }

    @Override
    public void delete(String id) {
        ayUserRepository.deleteById(id);
    }

    @Override
    public Page<AyUser> findAll(Pageable pageable) {
        return ayUserRepository.findAll(pageable);
    }

    @Override
    public List<AyUser> findByName(String name) {
        return ayUserRepository.findByName(name);
    }

    @Override
    public List<AyUser> findByNameLike(String name) {
        return ayUserRepository.findByNameLike(name);
    }

    @Override
    public List<AyUser> findByIdIn(Collection<String> ids) {
        return ayUserRepository.findByIdIn(ids);
    }
}
