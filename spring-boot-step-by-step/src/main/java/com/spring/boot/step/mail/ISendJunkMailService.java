package com.spring.boot.step.mail;

import com.spring.boot.step.model.AyUser;

import java.util.List;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-15 15:42
 */
public interface ISendJunkMailService {

    boolean sendJunkMail(List<AyUser> ayUserList);
}
