package com.example.PetMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class PetMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetMicroserviceApplication.class, args);
		System.out.println(SpringVersion.getVersion());
	}

}
