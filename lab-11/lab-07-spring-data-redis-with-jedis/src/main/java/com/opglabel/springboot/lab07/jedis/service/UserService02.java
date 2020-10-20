package com.opglabel.springboot.lab07.jedis.service;

import com.opglabel.springboot.lab07.jedis.cacheobject.UserCacheObject;
import com.opglabel.springboot.lab07.jedis.dao.UserCacheDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService02 {
    @Autowired
    private UserCacheDao userCacheDao;

    public UserCacheObject get(Integer id) {
        return userCacheDao.get(id);
    }

    public void set(UserCacheObject object, Integer id) {
        userCacheDao.set(object, id);
    }

}
