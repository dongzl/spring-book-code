package com.spring.boot.step;

import com.spring.boot.step.model.AyUser;
import com.spring.boot.step.repository.AyUserRepository;
import com.spring.boot.step.service.IAyUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StepByStepApplicationTests {

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
}
