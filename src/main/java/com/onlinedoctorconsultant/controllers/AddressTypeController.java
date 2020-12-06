package com.onlinedoctorconsultant.controllers;

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

import com.onlinedoctorconsultant.entities.info.AddressType;
import com.onlinedoctorconsultant.helpers.IBaseController;
import com.onlinedoctorconsultant.helpers.constants.IRestConstants;
import com.onlinedoctorconsultant.services.AddressTypeService;

/**
 * @author Amruta 5th Dec 2020
 * 
 * @endpoint /api/addressType
 *
 */
@RestController
@RequestMapping(IRestConstants.SEPARATOR + IRestConstants.API_BASE + IRestConstants.SEPARATOR + IRestConstants.ADDRESS_TYPE)
public class AddressTypeController implements IBaseController<AddressType, Long>, IRestConstants {

	@Autowired
	AddressTypeService addressTypeService;
	
	/**
	 * GET - api/addressType
	 * 
	 * Get All AddressType Entity List where deleted is false
	 * 
	 * @return List of AddressType Entity
	 */
	@GetMapping()
	@Override
	public List<AddressType> findAll() {
		return addressTypeService.findAll();
	}
	
	/**
	 * PUT - api/addressType
	 * 
	 * Save the AddressType Entity Instance
	 * 
	 * @param entity Instance of AddressType Entity
	 * @return New Created AddressType Entity Instance
	 */	
	@PutMapping()
	@Override
	public AddressType save(@RequestBody AddressType entity) {
		return addressTypeService.save(entity);
	}
	
	/**
	 * POST - api/addressType/{id}
	 * 
	 * Update the AddressType Entity Instance
	 * 
	 * @param id     Id of the AddressType Entity Instance
	 * @param entity Data to Update AddressType Entity Instance
	 * @return Update AddressType Entity Instance
	 * @throws ForUsExceptions
	 */
	@PostMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public AddressType update(@PathVariable(ID) Long id, @RequestBody AddressType entity) {
		return addressTypeService.update(id, entity);
	}
	
	/**
	 * DELETE - api/addressType/{id}
	 * 
	 * Delete the AddressType Entity Instance
	 * 
	 * @param id Id of the AddressType Entity Instance
	 * @throws ForUsExceptions
	 */
	@DeleteMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public void delete(@PathVariable(ID) Long id) {
		addressTypeService.delete(id);
	}
	
	/**
	 * GET - api/addressType/{id}
	 * 
	 * Get One AddressType Entity Instance
	 * 
	 * @param id Id of the AddressType Entity Instance
	 * @return AddressType Entity Instance
	 */
	@GetMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public AddressType findOne(@PathVariable(ID) Long id) {
		return addressTypeService.findOne(id);
	}
	
	/**
	 * GET - api/addressType/{addressType}
	 */
	@GetMapping(SEPARATOR + OPEN_BRACKET + ADDRESS_TYPE + CLOSE_BRACKET)
	public AddressType findOneByAddressType(@PathVariable(ADDRESS_TYPE) String addressType) {
		return addressTypeService.findOneByAddressType(addressType);
	}

}
