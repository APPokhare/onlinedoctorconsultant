package com.onlinedoctorconsultant.controllers.userinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinedoctorconsultant.entities.info.Patient;
import com.onlinedoctorconsultant.helpers.IBaseController;
import com.onlinedoctorconsultant.helpers.constants.IRestConstants;
import com.onlinedoctorconsultant.services.userinfo.PatientService;

/**
 * @author Amruta 5th Dec 2020
 *
 * @endpoint /api/Patient
 *
 */
@RestController
@RequestMapping(IRestConstants.SEPARATOR + IRestConstants.API_BASE + IRestConstants.SEPARATOR + IRestConstants.PATIENT)
public class PatientController implements IBaseController<Patient, Long>, IRestConstants {

	@Autowired
	PatientService patientService;

	/**
	 * GET - api/Patient
	 * 
	 * Get All Patient Entity List where deleted is false
	 * 
	 * @return List of Entity
	 */
	@GetMapping()
	@Override
	public List<Patient> findAll() {
		return patientService.findAll();
	}

	/**
	 * PUT - api/Patient
	 * 
	 * Save the Patient Entity Instance
	 * 
	 * @param entity Instance of Patient Entity
	 * @return New Created Instance of Patient Entity
	 */
	@PutMapping()
	@Override
	public Patient save(@RequestBody Patient entity) {
		return patientService.save(entity);
	}

	/**
	 * POST - api/Patient/{id}
	 * 
	 * Update the Patient Entity Instance
	 * 
	 * @param id     Id of the Patient Entity Instance
	 * @param entity Data to Update Patient Entity Instance
	 * @return Update Patient Entity Instance
	 * @throws ForUsExceptions
	 */
	@PostMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public Patient update(@PathVariable(ID) Long id, @RequestBody Patient entity) {
		return patientService.update(id, entity);
	}

	/**
	 * DELETE - api/Patient/{id}
	 * 
	 * Delete the Patient Entity Instance
	 * 
	 * @param id Id of the Patient Entity Instance
	 * @throws ForUsExceptions
	 */
	@DeleteMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public void delete(@PathVariable(ID) Long id) {
		patientService.delete(id);
	}

	/**
	 * GET - api/Patient/{id}
	 * 
	 * Get One Patient Entity Instance
	 * 
	 * @param id Id of the Patient Entity Instance
	 * @return Entity Instance
	 */
	@GetMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public Patient findOne(@PathVariable(ID) Long id) {
		return patientService.findOne(id);
	}

}
