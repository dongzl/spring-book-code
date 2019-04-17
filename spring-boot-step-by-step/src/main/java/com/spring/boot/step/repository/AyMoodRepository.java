package com.spring.boot.step.repository;

import com.spring.boot.step.model.AyMood;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-17 14:01
 */
public interface AyMoodRepository extends JpaRepository<AyMood, String> {

}
