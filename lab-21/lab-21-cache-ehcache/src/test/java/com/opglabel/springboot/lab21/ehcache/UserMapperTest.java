package com.opglabel.springboot.lab21.ehcache;

import com.opglabel.springboot.lab21.ehcache.Application;
import com.opglabel.springboot.lab21.ehcache.dataobject.UserDO;
import com.opglabel.springboot.lab21.ehcache.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserMapperTest {
    private static final String CACHE_NAME_USER = "users";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void testSelectById() {
        Integer id = 1;

        UserDO userDO = userMapper.selectById(id);

        System.out.println("user:" + userDO);

        Assert.assertNotNull("缓存为空",cacheManager.getCache(CACHE_NAME_USER).get(userDO.getId(),UserDO.class));

         userDO = userMapper.selectById(id);

        System.out.println("user:"+userDO);

    }

    @Test
    public void testInsert(){
        UserDO user = new UserDO();
        user.setUsername(UUID.randomUUID().toString());
        user.setPassword("123456");
        user.setCreateTime(new Date());
        user.setDeleted(0);
        userMapper.insert0(user);
        Assert.assertNotNull("缓存为空",cacheManager.getCache(CACHE_NAME_USER).get(user.getId(),UserDO.class));
    }

}
