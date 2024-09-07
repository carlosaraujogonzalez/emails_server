package com.gbtec.emailserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmailserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailserverApplication.class, args);
	}

}
