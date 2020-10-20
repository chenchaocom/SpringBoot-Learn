package com.opglabel.springboot.lab07.jedis.config;

import com.opglabel.springboot.lab07.jedis.listener.TestChannelTopicMessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        // 创建redisTemplate 对象
        RedisTemplate<String,Object> template = new RedisTemplate<>();
        // 设置开启事务支持
        template.setEnableTransactionSupport(true);
        // 设置key的序列化方式
        template.setKeySerializer(RedisSerializer.string());
        // 设置value的序列化方式
        template.setValueSerializer(RedisSerializer.json());
        // 设置RedisConnection 工厂
        template.setConnectionFactory(redisConnectionFactory);

        return template;

    }

    @Bean
    public RedisMessageListenerContainer listenerContainer(RedisConnectionFactory factory){
        // 创建 RedisMessageListenerContainer
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);

        // 添加监听器
        container.addMessageListener(new TestChannelTopicMessageListener(),new ChannelTopic("TEST"));

        return container;
    }

}
