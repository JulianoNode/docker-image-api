package com.jmr.web.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jmr.domain.Produto;
import com.jmr.service.ImageService;
import com.jmr.util.ImageMapper;

@RestController
@RequestMapping("/j1/images")
public class ProdutoController {

	Logger logger = LoggerFactory.getLogger(ProdutoController.class);

	@Autowired
	private ImageService service;
	
	@Autowired
	private ImageMapper mapper;
	
	@SuppressWarnings("rawtypes")
    @PostMapping
    public ResponseEntity save(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("tags") List<String> tags
            ) throws IOException {

		logger.info("Imagem recebida: name: {}, size: {}", file.getOriginalFilename(), file.getSize());

        Produto produto = mapper.mapToImage(file, name, tags);
        Produto savedImage = service.save(produto);
        URI imageUri = buildImageURL(savedImage);

        return ResponseEntity.created(imageUri).build();
    }
	
    private URI buildImageURL(Produto produto){
        String imagePath = "/" + produto.getId();
        return ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path(imagePath)
                .build().toUri();
    }

}