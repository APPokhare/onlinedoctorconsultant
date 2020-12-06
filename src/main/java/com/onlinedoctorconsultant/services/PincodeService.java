package com.onlinedoctorconsultant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedoctorconsultant.entities.info.Pincode;
import com.onlinedoctorconsultant.helpers.IBaseService;
import com.onlinedoctorconsultant.repositories.PincodeRepository;

/**
 * @author Amruta 5th Dec 2020
 */
@Service
public class PincodeService implements IBaseService<Pincode, Long> {

	@Autowired
	PincodeRepository pincodeRepository;

	/**
	 * Get All Pincode Entity List where deleted is false
	 * 
	 * @return List of Pincode Entity
	 */	
	@Override
	public List<Pincode> findAll() {
		return pincodeRepository.findAll();
	}
	
	/**
	 * Save the Pincode Entity Instance
	 * 
	 * @param entity Instance of Pincode Entity
	 * @return New Created Pincode Entity Instance 
	 */	
	@Override
	public Pincode save(Pincode entity) {
		return pincodeRepository.save(entity);
	}
	
	/**
	 * Update the Pincode Entity Instance
	 * 
	 * @param id     Id of the Pincode Entity Instance
	 * @param entity Data to Update Pincode Entity Instance
	 * @return Update Entity Pincode Entity
	 * @throws ForUsExceptions
	 */
	@Override
	public Pincode update(Long id, Pincode entity) {
		Pincode pincode = findOne(id);
			pincode.setCity(entity.getCity());
			pincode.setPincode(entity.getPincode());
			pincode.setState(entity.getState());
			return pincodeRepository.save(pincode);
	}
	
	/**
	 * Delete the Pincode Entity Instance
	 * 
	 * @param id Id of the Pincode Entity Instance
	 * @throws ForUsExceptions 
	 */
	@Override
	public void delete(Long id) {
		Pincode pincode = findOne(id);
			pincode.setDeleted(true);
			pincodeRepository.save(pincode);
	}
	
	 /**
	 * Get One Pincode Entity Instance
	 * 
	 * @param id Id of the Pincode Entity Instance
	 * @return Pincode Entity Instance
	 */
	@Override
	public Pincode findOne(Long id) {
		Pincode pincode = pincodeRepository.getOne(id);
			return pincode;
	}
	
	public Pincode findOneByPincode(String pincode) {
		return pincodeRepository.findOneByPincode(pincode);
	}

}
