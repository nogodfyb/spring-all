package com.example.springboottransaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springboottransaction.mapper")
public class SpringbootTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTransactionApplication.class, args);
	}

}
