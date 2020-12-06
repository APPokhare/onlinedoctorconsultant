package com.onlinedoctorconsultant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedoctorconsultant.entities.info.Appointments;
import com.onlinedoctorconsultant.helpers.IBaseService;
import com.onlinedoctorconsultant.repositories.AppointmentsRepository;

/**
 * @author Amruta 5th Dec 2020
 *
 */
@Service
public class AppointmentsService implements IBaseService<Appointments, Long> {

	@Autowired
	AppointmentsRepository appointmentsRepository;

	/**
	 * Get All Appointments Entity List where deleted is false
	 * 
	 * @return List of Appointments Entity
	 */
	@Override
	public List<Appointments> findAll() {
		return appointmentsRepository.findAll();
	}

	/**
	 * Save the Appointments Entity Instance
	 * 
	 * @param entity Instance of Appointments Entity
	 * @return New Created Instance of Appointments Entity
	 */
	@Override
	public Appointments save(Appointments entity) {
		return appointmentsRepository.save(entity);
	}

	/**
	 * Update the Appointments Entity Instance
	 * 
	 * @param id     Id of the Appointments Entity Instance
	 * @param entity Data to Update Appointments Entity Instance
	 * @return Update Appointments Entity Instance
	 * @throws ForUsExceptions
	 */
	@Override
	public Appointments update(Long id, Appointments entity) {
		Appointments appointments = findOne(id);
		appointments.setDoctor(entity.getDoctor());
		appointments.setDateAndTime(entity.getDateAndTime());
		appointments.setIsApproved(entity.getIsApproved());
		appointments.setPatient(entity.getPatient());
		
		return appointmentsRepository.save(appointments);
	}

	/**
	 * Delete the Appointments Entity Instance
	 * 
	 * @param id Id of the Appointments Entity Instance
	 * @throws ForUsExceptions
	 */
	@Override
	public void delete(Long id) {
		Appointments Appointments = findOne(id);
		Appointments.setDeleted(true);
		appointmentsRepository.save(Appointments);
	}

	/**
	 * Get One Appointments Entity Instance
	 * 
	 * @param id Id of the Appointments Entity Instance
	 * @return Appointments Entity Instance
	 */
	@Override
	public Appointments findOne(Long id) {
		Appointments Appointments = appointmentsRepository.getOne(id);

		return Appointments;

	}

}
