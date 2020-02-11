package com.example.latihanjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LatihanjavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LatihanjavaApplication.class, args);
	}

}
