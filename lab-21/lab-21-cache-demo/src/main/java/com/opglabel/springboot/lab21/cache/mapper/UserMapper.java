package com.opglabel.springboot.lab21.cache.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.opglabel.springboot.lab21.cache.dataobject.UserDO;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserMapper extends BaseMapper<UserDO> {


     @Cacheable(value = "user",key = "#id")
     UserDO selectById(Integer id);

     @CachePut(value = "user",key = "#user.id")
     default UserDO insert0(UserDO user){
         // 插入用户
         this.insert(user);
         // 返回用户
         return user;
     }


}
