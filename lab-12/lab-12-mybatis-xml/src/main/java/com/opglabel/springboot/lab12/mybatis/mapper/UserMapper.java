package com.opglabel.springboot.lab12.mybatis.mapper;

import com.opglabel.springboot.lab12.mybatis.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

@Mapper
public interface UserMapper {
    int insert(UserDO user);

    int updateById(UserDO user);

    int deleteById(@Param("id") Integer id); // 生产请使用标记删除，除非有点想不开。

    UserDO selectById(@Param("id") Integer id);

    UserDO selectByUsername(@Param("username") String username);

    List<UserDO> selectByIds(@Param("ids") Collection<Integer> ids);
}
