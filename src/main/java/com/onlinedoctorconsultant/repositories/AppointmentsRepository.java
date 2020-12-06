package com.onlinedoctorconsultant.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinedoctorconsultant.entities.info.Appointments;
import com.onlinedoctorconsultant.helpers.IBaseRepository;

/**
 * @author Amruta 5th Dec 2020
 *
 */
@Repository
public interface AppointmentsRepository extends IBaseRepository<Appointments, Long> {

	@Query("select a from Appointments a where a.deleted = false")
	public List<Appointments> findAll();

	@Query("select a from Appointments a where a.id =:id and a.deleted = false")
	public Appointments getOne(Long id);

}
