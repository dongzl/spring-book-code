package com.spring.boot.step.service.impl;

import com.spring.boot.step.model.AyUserRoleRel;
import com.spring.boot.step.repository.AyUserRoleRelRepository;
import com.spring.boot.step.service.IAyUserRoleRelService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-19 14:46
 */
public class AyUserRoleRelServiceImpl implements IAyUserRoleRelService {

    @Resource
    private AyUserRoleRelRepository ayUserRoleRelRepository;

    @Override
    public List<AyUserRoleRel> findByUserId(String userId) {
        return ayUserRoleRelRepository.findByUserId(userId);
    }
}
