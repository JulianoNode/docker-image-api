package com.jmr.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import com.jmr.domain.Produto;
import com.jmr.enus.ImageExtension;

public interface ImageRepository extends JpaRepository<Produto, String>, JpaSpecificationExecutor<Produto> {
	
	// METODO REFERENTE A QUERY 
	// SELECT * FROM PRODUTO WHERE 1 = 1 AND EXTENSION = 'PNG' AND ( NAME LIKE 'QUIRY' OR TAGS LIKE 'QUERY' )
	 default List<Produto> findByExtensionAndNameOrTagsLike(ImageExtension extension, String query){
	  	 
		 Specification<Produto> conjunction = (root, querySQL, criteriaBuilder) -> criteriaBuilder.conjunction();
		 
		 Specification<Produto> spec = Specification.where( conjunction );
	        
		 if(extension != null){
	     //AND EXTENSION = 'PNG'
			 Specification<Produto> extensionEqual = (root, querySQL, criteriaBuilder) -> 
			 criteriaBuilder.equal(root.get("extension"), extension);
			 
			 spec = spec.and(extensionEqual);			 
	        }
		 
	     if(StringUtils.hasText(query)){
	     //  AND ( NAME LIKE 'QUIRY' OR TAGS LIKE 'QUERY' )	
	    	 Specification<Produto> nameLike = (root, q, cb) ->
	    	 cb.like(cb.upper(root.get("name")), "%" + query.toUpperCase() + "%");
	    	 Specification<Produto> tagsLike = (root, q, cb) ->
	    	 cb.like(cb.upper(root.get("tags")), "%" + query.toUpperCase() + "%");
	         
	    	 Specification<Produto> nameOrTagsLike = Specification.anyOf(nameLike, tagsLike);
	    	 
	    	 spec = spec.and(nameOrTagsLike);
	        }		 
		 
		 return findAll(spec);
	    }
	}

