package com.spring.boot.step.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-19 14:39
 */
@Entity
@Table(name = "ay_user_role_rel")
public class AyUserRoleRel {

    @Id
    private String userId;

    private String roleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
