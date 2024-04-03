package com.jmr.repository;

import static com.jmr.repository.specs.GenericSpecs.conjunction;
import static com.jmr.repository.specs.ImageSpecs.extensionEqual;
import static com.jmr.repository.specs.ImageSpecs.nameLike;
import static com.jmr.repository.specs.ImageSpecs.tagsLike;
import static org.springframework.data.jpa.domain.Specification.anyOf;
import static org.springframework.data.jpa.domain.Specification.where;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import com.jmr.domain.Produto;
import com.jmr.enus.ImageExtension;

public interface ImageRepository extends JpaRepository<Produto, String>, JpaSpecificationExecutor<Produto> {

	// METODO REFERENTE A QUERY
	default List<Produto> findByExtensionAndNameOrTagsLike(ImageExtension extension, String query) {

		Specification<Produto> spec = where(conjunction());

		if (extension != null) {
			spec = spec.and(extensionEqual(extension));
		}

		if (StringUtils.hasText(query)) {
			spec = spec.and(anyOf(nameLike(query), tagsLike(query)));
		}

		return findAll(spec);
	}
}
