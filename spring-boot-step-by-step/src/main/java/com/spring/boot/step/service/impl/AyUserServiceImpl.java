package com.spring.boot.step.service.impl;

import com.spring.boot.step.model.AyUser;
import com.spring.boot.step.repository.AyUserRepository;
import com.spring.boot.step.service.IAyUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Resource
    private RedisTemplate redisTemplate;

    private static final String ALL_USER = "ALL_USER_LIST";

    @Override
    public AyUser findById(String id) {
        List<AyUser> ayUserList = redisTemplate.opsForList().range(ALL_USER, 0, -1);
        if (ayUserList != null && ayUserList.size() > 0) {
            for (AyUser user : ayUserList) {
                if (user.getId().equals(id)) {
                    return user;
                }
            }
        }
        AyUser ayUser = ayUserRepository.findById(id).get();
        if (ayUser != null) {
            redisTemplate.opsForList().leftPush(ALL_USER, ayUser);
        }
        return ayUser;
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
