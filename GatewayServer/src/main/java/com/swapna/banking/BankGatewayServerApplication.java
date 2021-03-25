package com.swapna.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BankGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankGatewayServerApplication.class, args);
	}

}
