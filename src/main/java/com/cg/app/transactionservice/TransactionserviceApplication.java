package com.cg.app.transactionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.cg.app.transactionservice.entity.Transaction;

@SpringBootApplication
public class TransactionserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionserviceApplication.class, args);
	}
	
	@Bean
	public RestTemplate initialiseRestTemplate() {
		return new RestTemplate();
	}
	@Bean
	public Transaction initialiseTransaction() {
		return new Transaction();
	}
}

