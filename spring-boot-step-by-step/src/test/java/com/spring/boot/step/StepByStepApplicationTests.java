package com.spring.boot.step;

import com.spring.boot.step.model.AyMood;
import com.spring.boot.step.model.AyUser;
import com.spring.boot.step.model.AyUserAttachmentRel;
import com.spring.boot.step.mq.AyMoodProducer;
import com.spring.boot.step.repository.AyUserRepository;
import com.spring.boot.step.service.IAyMoodService;
import com.spring.boot.step.service.IAyUserAttachmentRelService;
import com.spring.boot.step.service.IAyUserService;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StepByStepApplicationTests {

    Logger logger = LogManager.getLogger(this.getClass());

    @Resource
    JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads() {

    }

    @Test
    public void mySqlTest() {
        String sql = "select id, name, password from ay_user";
        List<AyUser> userList = (List<AyUser>) jdbcTemplate.query(sql, new RowMapper<AyUser>() {

            @Override
            public AyUser mapRow(ResultSet resultSet, int i) throws SQLException {
                AyUser user = new AyUser();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        });
        System.out.println("查询成功：");
        for (AyUser user : userList) {
            System.out.println("[id]:" + user.getId() + ";[name]:" + user.getName());
        }
    }

    @Resource
    private AyUserRepository ayUserRepository;

    @Test
    public void testRespority() {
        List<AyUser> userList = ayUserRepository.findAll();
        System.out.println("findAll():" + userList.size());
    }

    @Autowired
    private IAyUserService ayUserService;

    @Test
    public void testTransaction() {
        AyUser user = new AyUser();
        user.setId("3");
        user.setName("阿华");
        user.setPassword("123");
        ayUserService.save(user);
    }

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis() {
        redisTemplate.opsForValue().set("name", "ay");
        String name = (String)redisTemplate.opsForValue().get("name");
        System.out.println(name);
        redisTemplate.delete("name");
        redisTemplate.opsForValue().set("name", "a1");
        name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    public void testMybaits() {
        AyUser ayUser = ayUserService.findByNameAndPassword("阿毅", "123456");
        logger.info("==========" + ayUser.getName());
    }

    @Resource
    private IAyMoodService ayMoodService;

    @Test
    public void testAyMood() {
        AyMood ayMood = new AyMood();
        ayMood.setId("1");
        ayMood.setUserId("1");
        ayMood.setPraiseNum(0);
        ayMood.setContent("这是我的第一条微信说说！！");
        ayMood.setPublishTime(new Date());
        AyMood mood = ayMoodService.save(ayMood);
    }

    @Resource
    private AyMoodProducer ayMoodProducer;

    @Test
    public void testActiveMQ() {
        Destination destination = new ActiveMQQueue("ay.queue");
        ayMoodProducer.sendMessage(destination, "hello,mq!!!");
    }

    @Test
    public void testActiveMQAsynSave() {
        AyMood ayMood = new AyMood();
        ayMood.setId("2");
        ayMood.setUserId("2");
        ayMood.setPraiseNum(0);
        ayMood.setContent("这是我的第一条微信说说！！！");
        ayMood.setPublishTime(new Date());
        String msg = ayMoodService.asynSave(ayMood);
        System.out.println("异步发表说说：" + msg);
    }

    @Resource
    private IAyUserAttachmentRelService ayUserAttachmentRelService;

    @Test
    public void testMongoDB() {
        AyUserAttachmentRel ayUserAttachmentRel = new AyUserAttachmentRel();
        ayUserAttachmentRel.setId("1");
        ayUserAttachmentRel.setUserId("1");
        ayUserAttachmentRel.setFileName("个人简历.doc");
        ayUserAttachmentRelService.save(ayUserAttachmentRel);
        System.out.println("保存成功");
    }
}
