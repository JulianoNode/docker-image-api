package com.jmr.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.jmr.domain.Produto;
import com.jmr.enus.ImageExtension;
import com.jmr.repository.ImageRepository;

@Configuration
@Service
public class DBService {
	Logger logger = LoggerFactory.getLogger(DBService.class);
	
    @Bean
    Produto commandLineRunner(@Autowired ImageRepository imageRepository) {
    	
		Produto prod = new Produto(null, "Juliano", 1100L, ImageExtension.JPG, null, "Eu", null);
		System.out.println(); 
		logger.info("Produto salvo com susseço : {}", prod);
		System.out.println();		
		return imageRepository.save(prod);
			
	}

}
