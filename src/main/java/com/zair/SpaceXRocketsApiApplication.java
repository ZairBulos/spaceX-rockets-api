package com.zair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpaceXRocketsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceXRocketsApiApplication.class, args);
	}

}
