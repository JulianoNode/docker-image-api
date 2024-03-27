package com.JMR.images;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ImagesApp {

	public static void main(String[] args) {
		SpringApplication.run(ImagesApp.class, args);
	}

}
