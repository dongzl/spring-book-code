package com.spring.boot.step.quartz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-15 15:12
 */
public class TestTask {

    private static final Logger logger = LogManager.getLogger(TestTask.class);

    public void run() {
        logger.info("定时器运行了！！！");
    }
}
