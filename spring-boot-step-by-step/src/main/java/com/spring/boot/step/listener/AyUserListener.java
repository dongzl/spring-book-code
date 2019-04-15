package com.spring.boot.step.listener;

import com.spring.boot.step.model.AyUser;
import com.spring.boot.step.service.IAyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-12 17:29
 */
@WebListener
public class AyUserListener implements ServletContextListener {

    Logger logger = LogManager.getLogger(this.getClass());

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private IAyUserService ayUserService;

    private static final String ALL_USER = "ALL_USER_LIST";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<AyUser> ayUserList = ayUserService.findAll();
        redisTemplate.delete(ALL_USER);
        redisTemplate.opsForList().leftPushAll(ALL_USER, ayUserList);
        List<AyUser> queryUserList = redisTemplate.opsForList().range(ALL_USER, 0, -1);
        //System.out.println("缓存中目前的用户数有：" + queryUserList.size() + "人");
        //System.out.println("ServletContext初始化上下文");
        logger.info("缓存中目前的用户数有：" + queryUserList.size() + "人");
        logger.info("ServletContext初始化上下文");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        System.out.println("ServletContext上下文销毁");
        logger.info("ServletContext上下文销毁");
    }
}
