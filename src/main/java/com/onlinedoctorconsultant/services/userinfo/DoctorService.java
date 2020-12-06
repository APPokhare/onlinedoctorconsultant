package com.onlinedoctorconsultant.services.userinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedoctorconsultant.entities.info.Doctor;
import com.onlinedoctorconsultant.helpers.IBaseService;
import com.onlinedoctorconsultant.repositories.userinfo.DoctorRepository;

/**
 * @author Amruta 5th Dec 2020
 *
 */
@Service
public class DoctorService implements IBaseService<Doctor, Long> {

	@Autowired
	DoctorRepository doctorRepository;

	/**
	 * Get All Doctor Entity List where deleted is false
	 * 
	 * @return List of Doctor Entity
	 */
	@Override
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}

	/**
	 * Save the Doctor Entity Instance
	 * 
	 * @param entity Instance of Doctor Entity
	 * @return New Created Instance of Doctor Entity
	 */
	@Override
	public Doctor save(Doctor entity) {
		return doctorRepository.save(entity);
	}

	/**
	 * Update the Doctor Entity Instance
	 * 
	 * @param id     Id of the Doctor Entity Instance
	 * @param entity Data to Update Doctor Entity Instance
	 * @return Update Doctor Entity Instance
	 * @throws ForUsExceptions
	 */
	@Override
	public Doctor update(Long id, Doctor entity) {
		Doctor doctor = findOne(id);
		doctor.setExp(entity.getExp());
		doctor.setLicense(entity.getLicense());
		doctor.setSpecialization(entity.getSpecialization());
		doctor.setUser(entity.getUser());
		
		return doctorRepository.save(doctor);
	}

	/**
	 * Delete the Doctor Entity Instance
	 * 
	 * @param id Id of the Doctor Entity Instance
	 * @throws ForUsExceptions
	 */
	@Override
	public void delete(Long id) {
		Doctor Doctor = findOne(id);
		Doctor.setDeleted(true);
		doctorRepository.save(Doctor);
	}

	/**
	 * Get One Doctor Entity Instance
	 * 
	 * @param id Id of the Doctor Entity Instance
	 * @return Doctor Entity Instance
	 */
	@Override
	public Doctor findOne(Long id) {
		Doctor Doctor = doctorRepository.getOne(id);

		return Doctor;

	}

}
