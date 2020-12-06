package com.onlinedoctorconsultant.controllers.userinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinedoctorconsultant.entities.info.Address;
import com.onlinedoctorconsultant.helpers.IBaseController;
import com.onlinedoctorconsultant.helpers.constants.IRestConstants;
import com.onlinedoctorconsultant.services.userinfo.AddressService;

/**
 * @author Amruta 5th Dec 2020
 *
 * @endpoint /api/address
 */
@RestController
@RequestMapping(IRestConstants.SEPARATOR + IRestConstants.API_BASE + IRestConstants.SEPARATOR + IRestConstants.ADDRESS)
public class AddressController implements IBaseController<Address, Long>, IRestConstants {

	@GetMapping(SEPARATOR + "hello")
	public String hello() {
		return "HelloWorld";
	}
	
	@Autowired
	AddressService addressService;
	
	/**
	 * GET - api/address
	 * 
	 * Get All Address Entity List where deleted is false
	 * 
	 * @return List of Address Entity
	 */
	@GetMapping()
	@Override
	public List<Address> findAll() {
		return addressService.findAll();
	}
	
	/**
	 * PUT - api/address
	 * 
	 * Save the Address Entity Instance
	 * 
	 * @param entity Instance of Address Entity
	 * @return New Created Address Entity Instance 
	 */
	@PutMapping()
	@Override
	public Address save(@RequestBody Address entity) {
		return addressService.save(entity);
	}

	/**
	 * POST - api/address/{id}
	 * 
	 * Update the Address Entity Instance
	 * 
	 * @param id     Id of the Address Entity Instance
	 * @param entity Data to Update Address Entity Instance
	 * @return Update Address Entity Instance
	 * @throws ForUsExceptions
	 */
	@PostMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public Address update(@PathVariable(ID) Long id, @RequestBody Address entity) {
		return addressService.update(id, entity);
	}

	/**
	 * DELETE - api/address/{id}
	 * 
	 * Delete the Address Entity Instance
	 * 
	 * @param id Id of the Address Entity Instance
	 * @throws ForUsExceptions
	 */
	@DeleteMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public void delete(@PathVariable(ID) Long id) {
		addressService.delete(id);
	}

	/**
	 * GET - api/address/{id}
	 * 
	 * Get One Address Entity Instance
	 * 
	 * @param id Id of the Address Entity Instance
	 * @return Address Entity Instance
	 */
	@GetMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public Address findOne(@PathVariable(ID) Long id) {
		return addressService.findOne(id);
	}

	/**
	 * GET - api/address/all/{username}
	 * 
	 */
	@GetMapping(SEPARATOR + OPEN_BRACKET + USERNAME + CLOSE_BRACKET)
	public List<Address> findAllUserAddress(@PathVariable(USERNAME) String username) {
		return addressService.findAllUserAddress(username);
	}

	/**
	 * GET - api/address/{username}/addressType/{addressType}
	 * 
	 */
	@GetMapping(SEPARATOR + OPEN_BRACKET + USERNAME + CLOSE_BRACKET + SEPARATOR + OPEN_BRACKET + ADDRESS_TYPE + CLOSE_BRACKET)
	public Address findOneUserAddressByAddressType(@PathVariable(USERNAME) String username, 
			@PathVariable(ADDRESS_TYPE) String addressType) {
		return addressService.findOneUserAddressByAddressType(username, addressType);
	}

	/**
	 * GET - api/address/{objectId}
	 * 
	 */
	@GetMapping(SEPARATOR + OPEN_BRACKET + OBJECT_ID + CLOSE_BRACKET)
	public Address findOneAddressByObjectId(@PathVariable(OBJECT_ID) Long objectId) {
		return addressService.findOneAddressByObjectId(objectId);
	}

	@GetMapping(SEPARATOR + "test")
	public String getName(Authentication authentication) {

		return authentication.getName();
	}
}
