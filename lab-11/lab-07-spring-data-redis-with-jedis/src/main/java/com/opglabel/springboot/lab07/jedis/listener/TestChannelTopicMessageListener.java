package com.opglabel.springboot.lab07.jedis.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class TestChannelTopicMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("收到 ChannelTopic 消息：");
        System.out.println("线程编号："+Thread.currentThread().getName());
        System.out.println("message:"+message);
        System.out.println("pattern:"+new String(bytes));
    }
}