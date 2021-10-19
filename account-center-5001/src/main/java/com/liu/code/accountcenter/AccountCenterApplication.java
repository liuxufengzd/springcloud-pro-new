package com.liu.code.accountcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AccountCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountCenterApplication.class, args);
    }

}
