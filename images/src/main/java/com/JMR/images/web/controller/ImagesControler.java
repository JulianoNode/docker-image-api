package com.JMR.images.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/v1/images")
public class ImagesControler {

    @SuppressWarnings("rawtypes")
	@PostMapping
    public ResponseEntity save(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("tags") List<String> tags) {

        Logger logger = LoggerFactory.getLogger(ImagesControler.class);
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
