package com.jmr.service;

import java.util.Optional;

import com.jmr.domain.Produto;

public interface ImageService {

	Produto save (Produto produto);
	
	Optional<Produto> getById(String id);
}
