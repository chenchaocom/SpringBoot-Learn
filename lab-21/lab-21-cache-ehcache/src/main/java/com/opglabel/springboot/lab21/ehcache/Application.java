package com.opglabel.springboot.lab21.ehcache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.opglabel.springboot.lab21.ehcache.mapper")
public class Application {
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class,args);
//    }
}
