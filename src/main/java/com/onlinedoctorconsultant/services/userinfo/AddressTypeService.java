package com.onlinedoctorconsultant.services.userinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedoctorconsultant.entities.info.AddressType;
import com.onlinedoctorconsultant.helpers.IBaseService;
import com.onlinedoctorconsultant.repositories.userinfo.AddressTypeRepository;

/**
 * @author Amruta 5th Dec 2020
 */
@Service
public class AddressTypeService implements IBaseService<AddressType, Long> {

	@Autowired
	AddressTypeRepository addressTypeRepository;

	/**
	 * Get All AddressType Entity List where deleted is false
	 * 
	 * @return List of AddressType Entity
	 */
	@Override
	public List<AddressType> findAll() {
		return addressTypeRepository.findAll();
	}

	/**
	 * Save the AddressType Entity Instance
	 * 
	 * @param entity Instance of AddressType Entity
	 * @return New Created Instance AddressType Entity
	 */
	@Override
	public AddressType save(AddressType entity) {
		return addressTypeRepository.save(entity);
	}

	/**
	 * Update the AddressType Entity Instance
	 * 
	 * @param id     Id of the AddressType Entity Instance
	 * @param entity Data to Update AddressType Entity Instance
	 * @return Update Entity AddressType Entity
	 * @throws ForUsExceptions
	 */
	@Override
	public AddressType update(Long id, AddressType entity) {
		AddressType addressType = findOne(id);
			addressType.setAddressType(entity.getAddressType());
			return addressTypeRepository.save(addressType);
	}

	/**
	 * Delete the AddressType Entity Instance
	 * 
	 * @param id Id of the AddressType Entity Instance
	 * @throws ForUsExceptions
	 */
	@Override
	public void delete(Long id)  {
		AddressType addressType = findOne(id);
			addressType.setDeleted(true);
			addressTypeRepository.save(addressType);
	}

	/**
	 * Get One AddressType Entity Instance
	 * 
	 * @param id Id of the AddressType Entity Instance
	 * @return AddressType Entity Instance
	 */
	@Override
	public AddressType findOne(Long id) {
		AddressType addressType = addressTypeRepository.getOne(id);
			return addressType;
	}

	public AddressType findOneByAddressType(String addressType) {
		return addressTypeRepository.findOneByAddressType(addressType);
	}

}
