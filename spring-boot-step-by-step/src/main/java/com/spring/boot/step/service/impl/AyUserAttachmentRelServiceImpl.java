package com.spring.boot.step.service.impl;

import com.spring.boot.step.model.AyUserAttachmentRel;
import com.spring.boot.step.repository.AyUserAttachmentRelRepository;
import com.spring.boot.step.service.IAyUserAttachmentRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-19 11:54
 */
@Service
public class AyUserAttachmentRelServiceImpl implements IAyUserAttachmentRelService {

    @Resource
    private AyUserAttachmentRelRepository ayUserAttachmentRelRepository;

    @Override
    public AyUserAttachmentRel save(AyUserAttachmentRel ayUserAttachmentRel) {
        return ayUserAttachmentRelRepository.save(ayUserAttachmentRel);
    }
}
