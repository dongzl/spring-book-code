package com.spring.boot.step.quartz;

import com.spring.boot.step.mail.ISendJunkMailService;
import com.spring.boot.step.model.AyUser;
import com.spring.boot.step.service.IAyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-15 15:19
 */
@Component
@Configurable
@EnableScheduling
public class SendMailQuartz {

    private static final Logger logger = LogManager.getLogger(SendMailQuartz.class);

    @Autowired
    private IAyUserService ayUserService;

    @Autowired
    private ISendJunkMailService sendJunkMailService;

    @Scheduled(cron = "*/5 * * * * *")
    public void run() {

        List<AyUser> ayUserList = ayUserService.findAll();
        if (ayUserList == null || ayUserList.size() <= 0) {
            return;
        }
        sendJunkMailService.sendJunkMail(ayUserList);
        logger.info("定时器运行了！！！");
    }
}
