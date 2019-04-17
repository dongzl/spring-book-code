package com.spring.boot.step.service;

import com.spring.boot.step.model.AyMood;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-17 14:02
 */
public interface IAyMoodService {

    AyMood save(AyMood mood);

    String asynSave(AyMood ayMood);
}
