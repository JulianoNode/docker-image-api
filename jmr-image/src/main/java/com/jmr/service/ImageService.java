package com.jmr.service;

import java.util.List;
import java.util.Optional;

import com.jmr.domain.Produto;
import com.jmr.enus.ImageExtension;

public interface ImageService {

	Produto save (Produto produto);
	
	Optional<Produto> getById(String id);

	List<Produto> search(ImageExtension extension, String query);
}
