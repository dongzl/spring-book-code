package com.spring.boot.step;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.Resource;

@SpringBootApplication
@ServletComponentScan
@ImportResource(locations = {"classpath:spring-mvc.xml"})
@EnableAsync
public class StepByStepApplication {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(StepByStepApplication.class, args);
        DruidDataSource druidDataSource = (DruidDataSource)context.getBean(DruidDataSource.class);
        System.out.println(druidDataSource.getConnection());
    }
}
