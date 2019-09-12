package com.spring.boot.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author dongzonglei
 * @description
 * @date 2019-09-12 15:03
 */
public class ZookeeperDistributedLocks {

    public static void main(String args[]) throws Exception {
        //创建zookeeper的客户端
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181", retryPolicy);
        client.start();

        //创建分布式锁, 锁空间的根节点路径为/curator/lock
        InterProcessMutex mutex = new InterProcessMutex(client, "/curator/lock");
        for (int i = 0; i < 10; i++) {
            new Thread(new DistributedLockThread(mutex, i)).start();
        }
        mutex.acquire();
        //获得了锁, 进行业务流程
        System.out.println("Enter mutex " + mutex.isAcquiredInThisProcess());
        //完成业务流程, 释放锁
        mutex.release();

        //关闭客户端
        client.close();
    }

    static class DistributedLockThread implements Runnable {

        private InterProcessMutex mutex;

        private Integer index;

        public DistributedLockThread(InterProcessMutex mutex, Integer index) {
            this.mutex = mutex;
            this.index = index;
        }

        @Override
        public void run() {
            try {
                System.out.println("Index start acquire lock " + index);
                mutex.acquire();
                Thread.sleep(5000);
                mutex.release();
                System.out.println("Index start release lock " + index);
            } catch (Exception e) {

            }
        }
    }
}
