package com.liu.code.shipcenter.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceProxyConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }
    // Seata是通过代理数据源实现分布式事务，所以需要配置io.seata.rm.datasource.DataSourceProxy的Bean，
    // 且是@Primary默认的数据源，否则事务不会回滚，无法实现分布式事务
    // 实现了DataSource,本质上也是DataSource,并在次基础上实现了RM的功能
    @Primary
    @Bean
    public DataSourceProxy dataSourceProxy(DataSource dataSource){
        return new DataSourceProxy(dataSource);
    }
}
