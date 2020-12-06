package com.onlinedoctorconsultant.services.userinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedoctorconsultant.entities.info.Patient;
import com.onlinedoctorconsultant.helpers.IBaseService;
import com.onlinedoctorconsultant.repositories.userinfo.PatientRepository;

/**
 * @author Amruta 5th Dec 2020
 *
 */
@Service
public class PatientService implements IBaseService<Patient, Long> {

	@Autowired
	PatientRepository patientRepository;

	/**
	 * Get All Patient Entity List where deleted is false
	 * 
	 * @return List of Patient Entity
	 */
	@Override
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

	/**
	 * Save the Patient Entity Instance
	 * 
	 * @param entity Instance of Patient Entity
	 * @return New Created Instance of Patient Entity
	 */
	@Override
	public Patient save(Patient entity) {
		return patientRepository.save(entity);
	}

	/**
	 * Update the Patient Entity Instance
	 * 
	 * @param id     Id of the Patient Entity Instance
	 * @param entity Data to Update Patient Entity Instance
	 * @return Update Patient Entity Instance
	 * @throws ForUsExceptions
	 */
	@Override
	public Patient update(Long id, Patient entity) {
		Patient patient = findOne(id);
		patient.setMedicalHistory(entity.getMedicalHistory());
		patient.setUser(entity.getUser());
		
		return patientRepository.save(patient);
	}

	/**
	 * Delete the Patient Entity Instance
	 * 
	 * @param id Id of the Patient Entity Instance
	 * @throws ForUsExceptions
	 */
	@Override
	public void delete(Long id) {
		Patient Patient = findOne(id);
		Patient.setDeleted(true);
		patientRepository.save(Patient);
	}

	/**
	 * Get One Patient Entity Instance
	 * 
	 * @param id Id of the Patient Entity Instance
	 * @return Patient Entity Instance
	 */
	@Override
	public Patient findOne(Long id) {
		Patient Patient = patientRepository.getOne(id);

		return Patient;

	}


}
