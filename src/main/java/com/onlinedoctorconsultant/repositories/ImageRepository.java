package com.onlinedoctorconsultant.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinedoctorconsultant.entities.info.Image;
import com.onlinedoctorconsultant.helpers.IBaseRepository;

/**
 * @author Amruta 5th Dec 2020
 */
@Repository
public interface ImageRepository extends IBaseRepository<Image, Long>{

	@Query("select a from Image a where a.deleted = false")
	public List<Image> findAll();

	@Query("select a from Image a where a.id =:id and a.deleted = false")
	public Image getOne(Long id);
	
}
