package com.jmr.util;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.jmr.domain.Produto;
import com.jmr.dto.ProdutoDTO;
import com.jmr.enus.ImageExtension;

@Component
public class ImageMapper {

	public Produto mapToImage(MultipartFile file, String name, List<String> tags) throws IOException{
	     return new Produto(
	        		null, 
	        		(name), 
	        		(file.getSize()), 
	        		(ImageExtension.valueOf(MediaType.valueOf(file.getContentType()))), 
	        		null, 
	        		(String.join(",", tags)), 
	        		(file.getBytes())
	        		
	    );		
	}
	
    public ProdutoDTO imageToDTO(Produto prod, String url){
        return new ProdutoDTO(
                (url),
                (prod.getExtension().name()),
                (prod.getName()),
                (prod.getSize()),
                (prod.getUploadDate().toLocalDate())                
                );
    }

}
