package com.liu.code.shipcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ShipCenter9001Application {

	public static void main(String[] args) {
		SpringApplication.run(ShipCenter9001Application.class, args);
	}

}
