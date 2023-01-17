package com.creditmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CreditManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditManagerApplication.class, args);
		System.out.println("Credit Manager app running");
	}

}
