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

import com.onlinedoctorconsultant.entities.info.Doctor;
import com.onlinedoctorconsultant.helpers.IBaseController;
import com.onlinedoctorconsultant.helpers.constants.IRestConstants;
import com.onlinedoctorconsultant.services.userinfo.DoctorService;

/**
 * @author Amruta 5th Dec 2020
 *
 * @endpoint /api/Doctor
 *
 */
@RestController
@RequestMapping(IRestConstants.SEPARATOR + IRestConstants.API_BASE + IRestConstants.SEPARATOR + IRestConstants.DOCTOR)
public class DoctorController implements IBaseController<Doctor, Long>, IRestConstants {

	@Autowired
	DoctorService doctorService;

	/**
	 * GET - api/Doctor
	 * 
	 * Get All Doctor Entity List where deleted is false
	 * 
	 * @return List of Entity
	 */
	@GetMapping()
	@Override
	public List<Doctor> findAll() {
		return doctorService.findAll();
	}

	/**
	 * PUT - api/Doctor
	 * 
	 * Save the Doctor Entity Instance
	 * 
	 * @param entity Instance of Doctor Entity
	 * @return New Created Instance of Doctor Entity
	 */
	@PutMapping()
	@Override
	public Doctor save(@RequestBody Doctor entity) {
		return doctorService.save(entity);
	}

	/**
	 * POST - api/Doctor/{id}
	 * 
	 * Update the Doctor Entity Instance
	 * 
	 * @param id     Id of the Doctor Entity Instance
	 * @param entity Data to Update Doctor Entity Instance
	 * @return Update Doctor Entity Instance
	 * @throws ForUsExceptions
	 */
	@PostMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public Doctor update(@PathVariable(ID) Long id, @RequestBody Doctor entity) {
		return doctorService.update(id, entity);
	}

	/**
	 * DELETE - api/Doctor/{id}
	 * 
	 * Delete the Doctor Entity Instance
	 * 
	 * @param id Id of the Doctor Entity Instance
	 * @throws ForUsExceptions
	 */
	@DeleteMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public void delete(@PathVariable(ID) Long id) {
		doctorService.delete(id);
	}

	/**
	 * GET - api/Doctor/{id}
	 * 
	 * Get One Doctor Entity Instance
	 * 
	 * @param id Id of the Doctor Entity Instance
	 * @return Entity Instance
	 */
	@GetMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public Doctor findOne(@PathVariable(ID) Long id) {
		return doctorService.findOne(id);
	}

}
