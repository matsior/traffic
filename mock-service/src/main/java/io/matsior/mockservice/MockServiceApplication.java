package io.matsior.mockservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MockServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(MockServiceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MockServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(@Value("${mock.test-value}") String testValue) {
		return args -> log.info("Test value: {}", testValue);
	}

}
