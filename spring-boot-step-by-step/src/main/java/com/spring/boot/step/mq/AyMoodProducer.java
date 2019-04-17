package com.spring.boot.step.mq;

import com.spring.boot.step.model.AyMood;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-17 14:18
 */
@Service
public class AyMoodProducer {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(Destination destination, final String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    public void sendMessage(Destination destination, final AyMood ayMood) {
        jmsMessagingTemplate.convertAndSend(destination, ayMood);
    }
}
