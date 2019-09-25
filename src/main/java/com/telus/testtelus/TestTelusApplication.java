package com.telus.testtelus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@EnableScheduling     // for Scheduled Tasks
public class TestTelusApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestTelusApplication.class, args);
	}

}
