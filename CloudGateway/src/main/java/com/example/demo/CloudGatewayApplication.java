package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
@EnableDiscoveryClient
@SpringBootApplication
public class CloudGatewayApplication {

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("r1", r -> r.path("/departements/**").uri("http://localhost:5008/departements/all"))
				.route("r2", r -> r.path("/user/**").uri("http://localhost:8063/user"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApplication.class, args);
	}

}
