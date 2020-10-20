package com.opglabel.springboot.lab12.mybatis.mapper;

import com.opglabel.springboot.lab12.mybatis.dataobject.UserDO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<UserDO> {


    default UserDO selectByUsername(@Param("username") String username){
        return selectOne(new QueryWrapper<UserDO>().eq("username",username));
    }

    default IPage<UserDO> selectPageByCreateTime(IPage<UserDO> ipage,@Param("createTime")Date createTime){
        return selectPage(ipage,new QueryWrapper<UserDO>().gt("create_time",createTime));
    }


}
