package com.spring.boot.step;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

@SpringBootApplication
@ServletComponentScan
public class StepByStepApplication {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(StepByStepApplication.class, args);
        DruidDataSource druidDataSource = (DruidDataSource)context.getBean(DruidDataSource.class);
        System.out.println(druidDataSource.getConnection());
    }
}
