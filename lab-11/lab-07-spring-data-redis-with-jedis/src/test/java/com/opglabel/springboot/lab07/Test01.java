package com.opglabel.springboot.lab07;

import com.opglabel.springboot.lab07.jedis.cacheobject.UserCacheObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01 {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setStringKey(){
        stringRedisTemplate.opsForValue().set("yuanma","shuai");
    }

    @Test
    public void testStringKey2(){
        redisTemplate.opsForValue().set("hello","world");
        System.out.println(redisTemplate.opsForValue().get("hello"));
    }

    @Test
    public void testStringSetKeyUserCache(){
        UserCacheObject userCacheObject = new UserCacheObject()
                .setId(1)
                .setName("芋道源码")
                .setGender(1);

        String key = String.format("user:%d", userCacheObject.getId());
        redisTemplate.opsForValue().set(key,userCacheObject);
    }

    @Test
    public void testStringGetKeyUserCache() {
        String key = String.format("user:%d", 1);
        Object value = redisTemplate.opsForValue().get(key);
        System.out.println(value);
    }

}
