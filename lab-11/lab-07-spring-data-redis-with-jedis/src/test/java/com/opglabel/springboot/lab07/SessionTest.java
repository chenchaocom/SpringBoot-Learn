package com.opglabel.springboot.lab07;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SessionTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test01(){
        String result = stringRedisTemplate.execute(new SessionCallback<String>() {
            @Override
            public String execute(RedisOperations redisOperations) throws DataAccessException {
                for (int i = 0; i < 100; i++) {
                    redisOperations.opsForValue().set(String.format("hello:%d", i + 3), "world");
                }
                return (String) redisOperations.opsForValue().get(String.format("hello:%d", 3));
            }
        });

        System.out.println("result:"+result);
    }
}
