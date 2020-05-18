package com.opglabel.springboot.lab07.jedis.cacheobject;

/**
 * 用户缓存对象
 */
public class UserCacheObject {

    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 昵称
     */
    private String name;
    /**
     * 性别
     */
    private Integer gender;


    public Integer getId() {
        return id;
    }

    public UserCacheObject setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserCacheObject setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public UserCacheObject setGender(Integer gender) {
        this.gender = gender;
        return this;
    }
}
