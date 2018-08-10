package com.liumce.mamabike;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.liumce.mamabike.user.dao")
@SpringBootApplication
public class MamabikeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MamabikeApplication.class, args);
	}
}
