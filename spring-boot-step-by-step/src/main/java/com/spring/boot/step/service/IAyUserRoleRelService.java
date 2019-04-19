package com.spring.boot.step.service;

import com.spring.boot.step.model.AyUserRoleRel;

import java.util.List;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-19 14:41
 */
public interface IAyUserRoleRelService {

    List<AyUserRoleRel> findByUserId(String userId);
}
