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

import com.onlinedoctorconsultant.entities.info.Appointments;
import com.onlinedoctorconsultant.helpers.IBaseController;
import com.onlinedoctorconsultant.helpers.constants.IRestConstants;
import com.onlinedoctorconsultant.services.userinfo.AppointmentsService;

/**
 * @author Amruta 5th Dec 2020
 *
 * @endpoint /api/appointments
 *
 */
@RestController
@RequestMapping(IRestConstants.SEPARATOR + IRestConstants.API_BASE + IRestConstants.SEPARATOR + IRestConstants.APPOINTMENTS)
public class AppointmentsController implements IBaseController<Appointments, Long>, IRestConstants {

	@Autowired
	AppointmentsService appointmentsService;

	/**
	 * GET - api/Appointments
	 * 
	 * Get All Appointments Entity List where deleted is false
	 * 
	 * @return List of Entity
	 */
	@GetMapping()
	@Override
	public List<Appointments> findAll() {
		return appointmentsService.findAll();
	}

	/**
	 * PUT - api/Appointments
	 * 
	 * Save the Appointments Entity Instance
	 * 
	 * @param entity Instance of Appointments Entity
	 * @return New Created Instance of Appointments Entity
	 */
	@PutMapping()
	@Override
	public Appointments save(@RequestBody Appointments entity) {
		return appointmentsService.save(entity);
	}

	/**
	 * POST - api/Appointments/{id}
	 * 
	 * Update the Appointments Entity Instance
	 * 
	 * @param id     Id of the Appointments Entity Instance
	 * @param entity Data to Update Appointments Entity Instance
	 * @return Update Appointments Entity Instance
	 * @throws ForUsExceptions
	 */
	@PostMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public Appointments update(@PathVariable(ID) Long id, @RequestBody Appointments entity) {
		return appointmentsService.update(id, entity);
	}

	/**
	 * DELETE - api/Appointments/{id}
	 * 
	 * Delete the Appointments Entity Instance
	 * 
	 * @param id Id of the Appointments Entity Instance
	 * @throws ForUsExceptions
	 */
	@DeleteMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public void delete(@PathVariable(ID) Long id) {
		appointmentsService.delete(id);
	}

	/**
	 * GET - api/Appointments/{id}
	 * 
	 * Get One Appointments Entity Instance
	 * 
	 * @param id Id of the Appointments Entity Instance
	 * @return Entity Instance
	 */
	@GetMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public Appointments findOne(@PathVariable(ID) Long id) {
		return appointmentsService.findOne(id);
	}

}
