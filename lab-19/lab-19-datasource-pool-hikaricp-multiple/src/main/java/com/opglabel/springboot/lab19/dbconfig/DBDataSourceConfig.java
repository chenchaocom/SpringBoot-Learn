package com.opglabel.springboot.lab19.dbconfig;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

@Configuration
public class DBDataSourceConfig {

    @Primary
    @Bean(name = "orderDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.orders")
    public DataSourceProperties orderDataSourceProperties(){
        return new DataSourceProperties();
    }

    /**
     * 创建Order 数据源
     * @return
     */
    @Bean(name = "orderDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.orders.hikari")
    public DataSource orderDataSource(){
        return createHikariDataSource(this.orderDataSourceProperties());
    }


    /**
     * 创建User 数据源
     * @return
     */
    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.users.hikari")
    public DataSource userDataSource(){
        return createHikariDataSource(this.userDataSourceProperties());
    }





    @Bean(name = "userDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.users")
    public DataSourceProperties userDataSourceProperties(){
        return new DataSourceProperties();
    }

    public static HikariDataSource createHikariDataSource(DataSourceProperties dataSourceProperties) {

        HikariDataSource hikariDataSource = dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
        if(StringUtils.hasText(dataSourceProperties.getName())){

            hikariDataSource.setPoolName(dataSourceProperties.getName());
        }
        return hikariDataSource;

    }

}
