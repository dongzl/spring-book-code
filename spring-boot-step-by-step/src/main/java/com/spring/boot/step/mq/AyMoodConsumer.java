package com.spring.boot.step.mq;

import com.spring.boot.step.model.AyMood;
import com.spring.boot.step.service.IAyMoodService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-17 14:20
 */
@Component
public class AyMoodConsumer {

    @JmsListener(destination = "ay.queue")
    public void receiveQueue(String text) {
        System.out.println("用户发表说说【" + text + "】成功");
    }

    @Resource
    private IAyMoodService ayMoodService;

    @JmsListener(destination = "ay.queue.asyn.save")
    public void receiveQueue(AyMood ayMood) {
        ayMoodService.save(ayMood);
    }
}
