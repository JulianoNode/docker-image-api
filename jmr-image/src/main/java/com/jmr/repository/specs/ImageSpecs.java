package com.jmr.repository.specs;

import org.springframework.data.jpa.domain.Specification;

import com.jmr.domain.Produto;
import com.jmr.enus.ImageExtension;

public class ImageSpecs {

    private ImageSpecs(){}

	// SELECT * FROM PRODUTO WHERE 1 = 1 AND EXTENSION = 'PNG' AND ( NAME LIKE 'QUIRY' OR TAGS LIKE 'QUERY' )
    public static Specification<Produto> extensionEqual(ImageExtension extension){
        return (root, querySQL, criteriaBuilder) -> 
        criteriaBuilder.equal(root.get("extension"), extension);
    }

    public static Specification<Produto> nameLike(String name){
        return (root, querySQL, criteriaBuilder) -> 
        criteriaBuilder.like( criteriaBuilder.upper(root.get("name")), "%" + name.toUpperCase() + "%" );
    }

    public static Specification<Produto> tagsLike(String tags){
        return (root, querySQL, criteriaBuilder) -> 
        criteriaBuilder.like( criteriaBuilder.upper(root.get("tags")), "%" + tags.toUpperCase() + "%" );
    }
}
