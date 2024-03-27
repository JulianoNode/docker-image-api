package com.JMR.images.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JMR.images.domain.entity.Image;
import com.JMR.images.repository.ImageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository repository;

	@Override
	@Transactional
	public Image save(Image image) {
		return repository.save(image);
	}

}
