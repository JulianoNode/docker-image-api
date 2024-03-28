package com.jmr.web.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jmr.domain.Produto;
import com.jmr.enus.ImageExtension;
import com.jmr.service.ImageService;

@RestController
@RequestMapping("/j1/images")
public class ProdutoController {

	Logger logger = LoggerFactory.getLogger(ProdutoController.class);

	@Autowired
	private ImageService service;
	
	@SuppressWarnings("rawtypes")
	@PostMapping
    public ResponseEntity save(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("tags") List<String> tags) throws IOException {

        System.out.println("\n");
        logger.info("Imagem recebida: name   : {}", file.getOriginalFilename(), file.getSize());
        logger.info("Imagem Content Type     : {}", file.getContentType());
        logger.info("Imagem Media Type       : {}", MediaType.valueOf(file.getContentType()));
        
        MediaType.valueOf(file.getContentType());
        
        Produto prod = new Produto(
        		null, 
        		"Juliano", 
        		1100L, 
        		ImageExtension.valueOf(MediaType.valueOf(file.getContentType())), 
        		null, 
        		"Eu", 
        		(file.getBytes())
        		);
		
		service.save(prod);

        return ResponseEntity.ok().build();
    }
}