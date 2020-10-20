package com.opglabel.springboot.lab19;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class MultipleHikariApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(MultipleHikariApplication.class);
    @Resource(name = "orderDataSource")
    private DataSource orderDataSource;

    @Resource(name = "userDataSource")
    private DataSource userDataSource;

    public static void main(String[] args) {
        SpringApplication.run(MultipleHikariApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {

        Connection orderDataSourceConnection = orderDataSource.getConnection();
        Connection userDataSourceConnection = userDataSource.getConnection();

        LOGGER.info("[run] [order 获取连接：{}]",orderDataSourceConnection);

        LOGGER.info("[run] [user 获取连接：{}]",userDataSourceConnection);



    }
}
