package com.spring.boot.step.actuator;


import com.spring.boot.step.service.IAyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dongzonglei
 * @description
 * @date 2019-05-09 18:04
 */
//@ConfigurationProperties(prefix = "endpoints.userEndPoints")
public class AyUserEndPoint extends AbstractEndpoint<Map<String, Object>> {

    @Autowired
    private IAyUserService ayUserService;

    public AyUserEndPoint() {
        super("userEndPoints ");
    }

    @Override
    public Map<String, Object> invoke() {
        Map<String, Object> result = new HashMap<>();
        result.put("current_time", new Date());
        result.put("user_num", ayUserService.findAll().size());
        return result;
    }
}
