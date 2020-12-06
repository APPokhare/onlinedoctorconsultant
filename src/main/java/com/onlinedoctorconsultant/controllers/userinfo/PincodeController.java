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

import com.onlinedoctorconsultant.entities.info.Pincode;
import com.onlinedoctorconsultant.helpers.IBaseController;
import com.onlinedoctorconsultant.helpers.constants.IRestConstants;
import com.onlinedoctorconsultant.services.userinfo.PincodeService;

/**
 * @author Amruta 5th Dec 2020
 *
 * @endpoint /api/pincode
 */
@RestController
@RequestMapping(IRestConstants.SEPARATOR + IRestConstants.API_BASE + IRestConstants.SEPARATOR + IRestConstants.PINCODE)
public class PincodeController implements IBaseController<Pincode, Long>, IRestConstants {

	@Autowired
	PincodeService pincodeService;

	/**
	 * GET - api/pincode
	 * 
	 * Get All Pincode Entity List where deleted is false
	 * 
	 * @return List of Pincode Entity
	 */
	@GetMapping()
	@Override
	public List<Pincode> findAll() {
		return pincodeService.findAll();
	}

	/**
	 * PUT - api/pincode
	 * 
	 * Save the Pincode Entity Instance
	 * 
	 * @param entity Instance of Pincode Entity
	 * @return New Created Instance of Pincode Entity
	 */
	@PutMapping()
	@Override
	public Pincode save(@RequestBody Pincode entity) {
		return pincodeService.save(entity);
	}

	/**
	 * POST - api/pincode/{id}
	 * 
	 * Update the Pincode Entity Instance
	 * 
	 * @param id     Id of the Pincode Entity Instance
	 * @param entity Data to Update Pincode Entity Instance
	 * @return Update Pincode Entity Instance
	 * @throws ForUsExceptions
	 */
	@PostMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public Pincode update(@PathVariable(ID) Long id, @RequestBody Pincode entity) {
		return pincodeService.update(id, entity);
	}

	/**
	 * DELETE - api/pincode/{id}
	 * 
	 * Delete the Pincode Entity Instance
	 * 
	 * @param id Id of the Pincode Entity Instance
	 * @throws ForUsExceptions
	 */
	@DeleteMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public void delete(@PathVariable(ID) Long id) {
		pincodeService.delete(id);
	}

	/**
	 * GET - api/pincode/{id}
	 * 
	 * Get One Pincode Entity Instance
	 * 
	 * @param id Id of the Pincode Entity Instance
	 * @return Pincode Entity Instance
	 */
	@GetMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public Pincode findOne(@PathVariable(ID) Long id) {
		return pincodeService.findOne(id);
	}
	
	/**
	 * GET - api/pincode/{pincode}
	 * 
	 */
	@GetMapping(SEPARATOR + OPEN_BRACKET + PINCODE + CLOSE_BRACKET)
	public Pincode findOneByPincode(@PathVariable(PINCODE) String pincode) {
		return pincodeService.findOneByPincode(pincode);
	}

}
