package com.spring.code.atomikos;

import com.spring.code.atomikos.order.entity.OrderInfoDO;
import com.spring.code.atomikos.order.repository.IOrderInfoDao;
import com.spring.code.atomikos.user.entity.UserInfoDO;
import com.spring.code.atomikos.user.repository.IUserInfoDao;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = { "classpath*:spring/applicationContext_v2.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class JTAServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private IOrderInfoDao orderInfoDao;

    @Autowired
    private IUserInfoDao userInfoDao;

    /**
     * 单独保存 user 到 user_info 数据库
     */
    @Test
    public void saveUser() {
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setUserName("test");
        userInfoDao.save(userInfoDO);
        //Assert.assertNotNull(userInfoDO.getUserId());
    }

    /**
     * 单独俣存 order 到 order_info 数据库
     */
    @Test
    public void saveOrder() {
        OrderInfoDO orderInfoDO = new OrderInfoDO();
        orderInfoDO.setUserId(1L);
        orderInfoDao.save(orderInfoDO);
        Assert.assertNotNull(orderInfoDO.getOrderId());
    }

    /**
     * 同时保存 user 到 user_info 数据库、order 到 order_info 数据库 
     */
    @Test
    public void saveUserAndOrderCommit() {
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setUserName("test1");
        userInfoDao.save(userInfoDO);
        OrderInfoDO orderInfoDO = new OrderInfoDO();
        orderInfoDO.setUserId(1L);
        orderInfoDao.save(orderInfoDO);
        Assert.assertNotNull(userInfoDO.getUserId());
        Assert.assertNotNull(orderInfoDO.getOrderId());
    }

    /**
     * order 回滚、user 一起回滚 
     */
    @Test
    public void saveUserAndOrderRollback() {
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setUserName("test1");
        userInfoDao.save(userInfoDO);
        OrderInfoDO orderInfoDO = new OrderInfoDO();
        orderInfoDO.setUserId(null); //user_id 不允许为空，回滚
        orderInfoDao.save(orderInfoDO);
        Assert.assertNotNull(userInfoDO.getUserId());
        Assert.assertNotNull(orderInfoDO.getOrderId());
    }

    /**
     * user 回滚、order 一起回滚 
     */
    @Test(expected = ArithmeticException.class)
    public void saveUserAndOrderRollback2() {
        OrderInfoDO orderInfoDO = new OrderInfoDO();
        orderInfoDO.setUserId(1L);
        orderInfoDao.save(orderInfoDO);
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setUserName("test1test1test1test1test1test1test1"); //user_name 过长，回滚
        userInfoDao.save(userInfoDO);
        Assert.assertNotNull(userInfoDO.getUserId());
        Assert.assertNotNull(orderInfoDO.getOrderId());
    }
}  
