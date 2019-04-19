package com.spring.boot.step.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-19 14:38
 */
@Table(name = "ay_role")
@Entity
public class AyRole {

    @Id
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
