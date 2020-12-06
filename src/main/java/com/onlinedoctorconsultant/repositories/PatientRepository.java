package com.onlinedoctorconsultant.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinedoctorconsultant.entities.info.Patient;
import com.onlinedoctorconsultant.helpers.IBaseRepository;

/**
 * @author Amruta 5th Dec 2020
 *
 */
@Repository
public interface PatientRepository extends IBaseRepository<Patient, Long> {

	@Query("select a from Patient a where a.deleted = false")
	public List<Patient> findAll();

	@Query("select a from Patient a where a.id =:id and a.deleted = false")
	public Patient getOne(Long id);

}
