package com.spring.boot.step.mail.impl;

import com.spring.boot.step.mail.ISendJunkMailService;
import com.spring.boot.step.model.AyUser;
import com.spring.boot.step.quartz.TestTask;
import com.spring.boot.step.repository.AyUserRepository;
import com.spring.boot.step.service.IAyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-15 15:43
 */
@Service
public class SendJunkMailServiceImpl implements ISendJunkMailService {

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    private IAyUserService ayUserService;

    @Value("${spring.mail.username}")
    private String from;

    private static final Logger logger = LogManager.getLogger(SendJunkMailServiceImpl.class);

    @Override
    public boolean sendJunkMail(List<AyUser> ayUserList) {
        try {
            if (ayUserList == null || ayUserList.size() <= 0) {
                return Boolean.FALSE;
            }
            for (AyUser user : ayUserList) {
                MimeMessage mimeMessage = this.mailSender.createMimeMessage();
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setFrom(from);
                message.setSubject("地瓜进入特卖");
                message.setTo("dongzonglei@jd.com");
                message.setText(user.getName() + "，你知道吗？厦门地瓜今日特卖，一斤只要9元");
                this.mailSender.send(mimeMessage);
            }
        } catch (Exception e) {
            logger.error("SendJunkMail error and ayUser=%s", ayUserList, e);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
