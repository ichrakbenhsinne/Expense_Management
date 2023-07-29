package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

public class DepencesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepencesApplication.class, args);
	}
	

	@Bean
	public RestTemplate resttemplate() {
		return new RestTemplate();
	}

}
