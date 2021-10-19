package com.liu.code.ordercenterconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
// 这里我们使用Druid数据源而不是hikari
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
public class OrderCenterConfig6001Application {

    public static void main(String[] args) {
        SpringApplication.run(OrderCenterConfig6001Application.class, args);
    }

}
