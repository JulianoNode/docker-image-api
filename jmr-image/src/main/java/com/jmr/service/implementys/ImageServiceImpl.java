package com.jmr.service.implementys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jmr.domain.Produto;
import com.jmr.repository.ImageRepository;
import com.jmr.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	private ImageRepository imageRepository;

	Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);
	
	@Override
	@Transactional
	public Produto save(Produto produto) {
	
		return imageRepository.save(produto);
	}

}
