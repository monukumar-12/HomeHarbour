package com.HomeHarbour.HomeHarbourApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HomeHarbourAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeHarbourAppApplication.class, args);
	}

}
