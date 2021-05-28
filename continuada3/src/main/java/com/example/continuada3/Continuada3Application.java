package com.example.continuada3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@EnableScheduling
@SpringBootApplication
public class Continuada3Application {

	public static void main(String[] args) {
		SpringApplication.run(Continuada3Application.class, args);
	}

}
