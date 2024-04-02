package com.jmr.web.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jmr.domain.Produto;
import com.jmr.dto.ProdutoDTO;
import com.jmr.enus.ImageExtension;
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
	

// Metodo para Salvar DB =======================================================================   
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
	
	// Retornado o Status mais correto da API 201 CREATED
    private URI buildImageURL(Produto produto){
    	//http://localhost:8080/j1/images/API 201 CREATED na URL
        String imagePath = "/" + produto.getId();
        return ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path(imagePath)
                .build().toUri();
    }
// Metodo para exsibir DB =======================================================================    
    
    @GetMapping("{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") String id){
        var possibleImage = service.getById(id);
        
        if(possibleImage.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var image = possibleImage.get();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(image.getExtension().getMediaType());
        headers.setContentLength(image.getSize());
        // inline; filename="image.PNG"
        headers.setContentDispositionFormData("inline; filename=\"" + image.getFileName() +  "\"", image.getFileName());

        return new ResponseEntity<>(image.getFile(), headers, HttpStatus.OK);
    }
    
// Metodo para search DB =======================================================================      
    
    // localhost:8080/v1/images?extension=PNG&query=Nature
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> search(
            @RequestParam(value = "extension", required = false, defaultValue = "") String extension,
            @RequestParam(value = "query",required = false) String query) throws InterruptedException {

        Thread.sleep(3000L);

        var result = service.search(ImageExtension.ofName(extension), query);

        var images = result.stream().map(image -> {
            var url = buildImageURL(image);
            return mapper.imageToDTO(image, url.toString());
        }).collect(Collectors.toList());

        return ResponseEntity.ok(images);
    }

}