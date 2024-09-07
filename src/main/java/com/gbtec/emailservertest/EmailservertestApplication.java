package com.gbtec.emailservertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmailservertestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailservertestApplication.class, args);
	}

}
