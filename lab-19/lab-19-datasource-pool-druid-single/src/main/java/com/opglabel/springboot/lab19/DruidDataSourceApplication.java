package com.opglabel.springboot.lab19;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class DruidDataSourceApplication implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(DruidDataSourceApplication.class);

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(DruidDataSourceApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("[run][获得数据源：{}]", dataSource.getClass());
    }
}
