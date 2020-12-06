package com.onlinedoctorconsultant.repositories.userinfo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinedoctorconsultant.entities.info.Reviews;
import com.onlinedoctorconsultant.helpers.IBaseRepository;

/**
 * @author Amruta 5th Dec 2020
 *
 */
@Repository
public interface ReviewsRepository extends IBaseRepository<Reviews, Long> {

	@Query("select a from Reviews a where a.deleted = false")
	public List<Reviews> findAll();

	@Query("select a from Reviews a where a.id =:id and a.deleted = false")
	public Reviews getOne(Long id);

	
}
