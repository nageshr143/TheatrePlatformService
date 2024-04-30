package com.sapient.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan({"com.sapient.controller", "com.sapient.service"})
@EntityScan("com.sapient.entity")
@EnableJpaRepositories("com.sapient.repository")
public class TheatrePlatformDriverApplication {
	

	
	@Value("${address.service.url}")
	private String addressServiceUrl;

	public static void main(String[] args) {
		SpringApplication.run(TheatrePlatformDriverApplication.class, args);
	}
	
	@Bean
	public WebClient webClient () {
		WebClient webClient =WebClient.builder()
				.baseUrl(addressServiceUrl).build();
		
		return webClient;
	}

}
