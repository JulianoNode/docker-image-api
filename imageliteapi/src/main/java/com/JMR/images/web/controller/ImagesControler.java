package com.JMR.images.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.JMR.images.domain.entity.Image;
import com.JMR.images.repository.ImageRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/images")
@Slf4j
@RequiredArgsConstructor
public class ImagesControler {

	@Autowired
	private ImageRepository repository;
	
    @SuppressWarnings("rawtypes")
	@PostMapping
    public ResponseEntity save(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("tags") List<String> tags) {
        
        log.info("Imagem recebida: name   : {}", file.getOriginalFilename(), file.getSize(), name, tags);
        log.info("Imagem ContentType      : {}", file.getContentType());

        Image image = Image
                        .builder()
                        .name(name)
                        .tags(String.join(",", tags))
                        .size(file.getSize())
                        .build();

        return ResponseEntity.ok().build();
    }

}
