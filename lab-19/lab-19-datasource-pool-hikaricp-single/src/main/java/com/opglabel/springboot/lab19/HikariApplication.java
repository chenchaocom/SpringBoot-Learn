package com.opglabel.springboot.lab19;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class HikariApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(HikariApplication.class);

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(HikariApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {

        Connection connection = dataSource.getConnection();

        LOGGER.info("[run] [获取连接：{}]",connection);
    }
}
