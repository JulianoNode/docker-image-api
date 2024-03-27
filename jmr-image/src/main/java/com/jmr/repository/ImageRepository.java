package com.jmr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jmr.domain.Produto;

public interface ImageRepository extends JpaRepository<Produto, String>{

}
