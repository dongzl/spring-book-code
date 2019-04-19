package com.spring.boot.step.repository;

import com.spring.boot.step.model.AyUserAttachmentRel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-19 11:53
 */
public interface AyUserAttachmentRelRepository extends MongoRepository<AyUserAttachmentRel, String> {

}
