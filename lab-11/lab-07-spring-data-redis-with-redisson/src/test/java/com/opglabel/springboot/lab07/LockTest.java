package com.opglabel.springboot.lab07;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LockTest {

    private static final String LOCK_KEY = "anylock";

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void test() throws InterruptedException {
        // 启动一个线程 先去获取锁
        new Thread(new Runnable() {
            @Override
            public void run() {
                 RLock lock = redissonClient.getLock(LOCK_KEY);
                 lock.lock(10, TimeUnit.SECONDS); // 加锁10s
            }
        }).start();

        Thread.sleep(1000L);

        System.out.println(String.format("准备开始获得锁时间：%s",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));

        RLock lock = redissonClient.getLock(LOCK_KEY);
        boolean tryLock = lock.tryLock(100, 10, TimeUnit.SECONDS);

        if (tryLock) {
            System.out.println(String.format("实际获得锁时间：%s", new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").format(new Date())));
        } else {
            System.out.println("加锁失败");
        }

    }



}
