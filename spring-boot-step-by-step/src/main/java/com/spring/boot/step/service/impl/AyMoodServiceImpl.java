package com.spring.boot.step.service.impl;

import com.spring.boot.step.model.AyMood;
import com.spring.boot.step.mq.AyMoodProducer;
import com.spring.boot.step.repository.AyMoodRepository;
import com.spring.boot.step.service.IAyMoodService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-17 14:03
 */
@Service
public class AyMoodServiceImpl implements IAyMoodService {

    @Resource
    private AyMoodRepository ayMoodRepository;

    @Override
    public AyMood save(AyMood mood) {
        return ayMoodRepository.save(mood);
    }

    private static Destination destination = new ActiveMQQueue("ay.queue.asyn.save");

    @Resource
    private AyMoodProducer ayMoodProducer;

    @Override
    public String asynSave(AyMood ayMood) {
        ayMoodProducer.sendMessage(destination, ayMood);
        return "success";
    }
}
