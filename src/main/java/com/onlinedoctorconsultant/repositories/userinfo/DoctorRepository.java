package com.onlinedoctorconsultant.repositories.userinfo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinedoctorconsultant.entities.info.Doctor;
import com.onlinedoctorconsultant.helpers.IBaseRepository;

/**
 * @author Amruta 5th Dec 2020
 *
 */
@Repository
public interface DoctorRepository extends IBaseRepository<Doctor, Long> {

	@Query("select a from Doctor a where a.deleted = false")
	public List<Doctor> findAll();

	@Query("select a from Doctor a where a.id =:id and a.deleted = false")
	public Doctor getOne(Long id);

}
