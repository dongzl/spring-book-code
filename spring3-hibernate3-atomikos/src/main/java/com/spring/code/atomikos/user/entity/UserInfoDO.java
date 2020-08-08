package com.spring.code.atomikos.user.entity;

/**
 * @author dongzonglei
 * @description
 * @date 2020/8/8 下午4:41
 */
public class UserInfoDO {
    
    private Long userId;
    
    private String userName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
