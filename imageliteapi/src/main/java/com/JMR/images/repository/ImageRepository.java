package com.JMR.images.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.JMR.images.domain.entity.Image;

public interface ImageRepository extends JpaRepository<Image, String>{

}
