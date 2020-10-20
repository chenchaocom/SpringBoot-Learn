package com.opglabel.springboot.lab47;

import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.InetSocketAddress;


@Configuration
@EnableConfigurationProperties(YunaiServerProperties.class)
public class YunaiServerAutoConfiguration {

    private Logger logger = LoggerFactory.getLogger(YunaiServerAutoConfiguration.class);

    @Bean
    @ConditionalOnClass(HttpServer.class)
    public HttpServer httpServer(YunaiServerProperties yunaiServerProperties) throws IOException {

        HttpServer httpServer = HttpServer.create(new InetSocketAddress(yunaiServerProperties.getPort()), 0);
        httpServer.start();
        logger.info("服务启动成功，端口为：{}",yunaiServerProperties.getPort());
        return httpServer;

    }



}
