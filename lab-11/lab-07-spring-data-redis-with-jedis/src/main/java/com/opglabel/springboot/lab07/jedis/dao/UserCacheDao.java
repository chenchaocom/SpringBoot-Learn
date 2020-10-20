package com.opglabel.springboot.lab07.jedis.dao;

import com.opglabel.springboot.lab07.jedis.cacheobject.UserCacheObject;
import com.opglabel.springboot.lab07.jedis.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserCacheDao {
    private static final String KEY_PATTERN = "USER:%d";

    @Resource(name = "redisTemplate")
    private ValueOperations<String,String> operations;


    private static String buildKey(Integer id) {
        return String.format(KEY_PATTERN, id);
    }

    public UserCacheObject get(Integer id){
        String key = buildKey(id);
        String value = operations.get(key);
        return JSONUtil.parseObject(value,UserCacheObject.class);
    }

    public void set(UserCacheObject object,Integer id){
        String key = buildKey(id);
        String value = JSONUtil.toJSONString(object);
        operations.set(key,value);

    }

}
