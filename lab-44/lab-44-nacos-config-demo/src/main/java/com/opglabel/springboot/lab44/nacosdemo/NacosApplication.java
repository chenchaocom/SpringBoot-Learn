package com.opglabel.springboot.lab44.nacosdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class NacosApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosApplication.class,args);
    }
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Component
    public class OrderPropertiesCommandLineRunner implements CommandLineRunner {

        @Autowired
        private OrderProperties orderProperties;


        @Override
        public void run(String... args) throws Exception {
            logger.info("createFrequencySecond----------"+ orderProperties.getCreateFrequencySeconds());
            logger.info("payTimeoutSeconds----------------"+orderProperties.getPayTimeoutSeconds());
        }
    }

    @Component
    public class ValueCommandLineRunner implements CommandLineRunner{

        @Value("${order.pay-timeout-seconds}")
        private Integer payTimeoutSeconds;
        @Value("${order.create-frequency-seconds}")
        private Integer createFrequencySeconds;
        @Override
        public void run(String... args) throws Exception {
            logger.info("createFrequencySecond--------"+ createFrequencySeconds);
            logger.info("payTimeoutSeconds-------------"+ payTimeoutSeconds);
        }
    }

}
