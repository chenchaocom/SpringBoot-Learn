package com.opglabel.springboot.lab07;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
@EnableTransactionManagement
public class TransactionTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test01(){
        stringRedisTemplate.setEnableTransactionSupport(true);

        // 执行想要的操作
        stringRedisTemplate.opsForValue().set("hello2", "world2");

    }


    @Test
    public void test02() {
        stringRedisTemplate.setEnableTransactionSupport(true);


        System.out.println( stringRedisTemplate.opsForValue().get("hello2"));;
    }
}
