package com.spring.boot.step.service.impl;

import com.spring.boot.step.model.AyRole;
import com.spring.boot.step.repository.AyRoleRepository;
import com.spring.boot.step.service.IAyRoleService;

import javax.annotation.Resource;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-19 14:45
 */
public class AyRoleServiceImpl implements IAyRoleService {

    @Resource
    private AyRoleRepository ayRoleRepository;

    @Override
    public AyRole find(String id) {
        return ayRoleRepository.findById(id).get();
    }
}
