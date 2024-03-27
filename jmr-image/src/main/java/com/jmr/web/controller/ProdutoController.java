package com.jmr.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/jmr")
public class ProdutoController {

	Logger logger = LoggerFactory.getLogger(ProdutoController.class);

	@SuppressWarnings("rawtypes")
	@PostMapping
    public ResponseEntity save(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("tags") List<String> tags) {

        System.out.println("\n");
        logger.info("Imagem recebida: name   : {}", file.getOriginalFilename(), file.getSize());
        logger.info("Nome definido da image  : {}", name);
        logger.info("Size definido da image  : {}", file.getSize());
        logger.info("Content Type da image   : {}", file.getContentType());
        logger.info("Resource da image       : {}", file.getResource());
        logger.info("To String da image      : {}", file.toString());
        logger.info("Hash Code da image      : {}", file.hashCode());
        logger.info("Equals da image         : {}", file.equals(file));
        logger.info("Tags                    : {}", tags);


        return ResponseEntity.ok().build();
    }
}