package com.spring.boot.step.model;

import javax.persistence.Id;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-19 11:51
 */
public class AyUserAttachmentRel {

    @Id
    private String id;

    private String userId;

    private String fileName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
