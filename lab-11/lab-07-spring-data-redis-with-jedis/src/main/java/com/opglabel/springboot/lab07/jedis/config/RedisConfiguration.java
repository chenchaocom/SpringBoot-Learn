package com.opglabel.springboot.lab07.jedis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        // 创建redisTemplate 对象
        RedisTemplate<String,Object> template = new RedisTemplate<>();

        return template;

    }

}
