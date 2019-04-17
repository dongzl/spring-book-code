package com.spring.boot.step.service.impl;

import com.spring.boot.step.dao.AyUserDao;
import com.spring.boot.step.model.AyUser;
import com.spring.boot.step.repository.AyUserRepository;
import com.spring.boot.step.service.IAyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author dongzonglei
 * @description
 * @date 2019-03-21 10:11
 */
@Service
@Transactional
public class AyUserServiceImpl implements IAyUserService {

    private static final Logger logger = LogManager.getLogger(AyUserServiceImpl.class);

    @Resource
    private AyUserRepository ayUserRepository;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private AyUserDao ayUserDao;

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
        try {
            System.out.println("开始做任务");
            long start = System.currentTimeMillis();
            List<AyUser> ayUserList = ayUserRepository.findAll();
            long end = System.currentTimeMillis();
            System.out.println("完成任务，耗时：" + (end - start) + "毫秒");
            return ayUserList;
        } catch (Exception e) {
            logger.error("method [findAll] error", e);
            return Collections.EMPTY_LIST;
        }
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

    @Override
    public AyUser findByNameAndPassword(String name, String password) {
        return ayUserDao.findByNameAndPassword(name, password);
    }

    @Override
    @Async
    public Future<List<AyUser>> findAsynAll() {
        try {
            System.out.println("开始做任务");
            long start = System.currentTimeMillis();
            List<AyUser> ayUserList = ayUserRepository.findAll();
            long end = System.currentTimeMillis();
            System.out.println("完成任务，耗时：" + (end - start) + "毫秒");
            return new AsyncResult<>(ayUserList);
        } catch (Exception e) {
            logger.error("method [findAll] error", e);
            return new AsyncResult<>(null);
        }
    }
}
