package com.opglabel.springboot.lab07;

import com.opglabel.springboot.lab07.jedis.cacheobject.UserCacheObject;
import com.opglabel.springboot.lab07.jedis.service.UserService02;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserService02Test {
    @Autowired
    private UserService02 userService02;

    @Test
    public void testSet(){
        UserCacheObject userCacheObject = new UserCacheObject()
                .setId(1)
                .setName("芋道源码")
                .setGender(1);

        userService02.set(userCacheObject,1);
    }
}
