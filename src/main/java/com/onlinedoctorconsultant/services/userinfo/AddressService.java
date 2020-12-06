package com.onlinedoctorconsultant.services.userinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedoctorconsultant.entities.info.Address;
import com.onlinedoctorconsultant.entities.info.AddressType;
import com.onlinedoctorconsultant.entities.info.User;
import com.onlinedoctorconsultant.helpers.IBaseService;
import com.onlinedoctorconsultant.repositories.userinfo.AddressRepository;
import com.onlinedoctorconsultant.repositories.userinfo.AddressTypeRepository;

/**
 * @author Amruta 5th Dec 2020
 */
@Service
public class AddressService implements IBaseService<Address, Long> {

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	UserService userService;

	@Autowired
	AddressTypeRepository addressTypeRepository;

	/**
	 * Get All Address Entity List where deleted is false
	 * 
	 * @return List of Address Entity
	 */
	@Override
	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	/**
	 * Save the Address Entity Instance
	 * 
	 * @param entity Instance of Address Entity
	 * @return New Created Address Entity Instance
	 */
	@Override
	public Address save(Address entity) {
		return addressRepository.save(entity);
	}

	/**
	 * Update the Address Entity Instance
	 * 
	 * @param id     Id of the Address Entity Instance
	 * @param entity Data to Update Address Entity Instance
	 * @return Update Entity Address Entity
	 * @throws ForUsExceptions
	 */
	@Override
	public Address update(Long id, Address entity) {
		Address address = findOne(id);

		address.setAddressLine1(entity.getAddressLine1());
		address.setAddressLine2(entity.getAddressLine2());
		address.setAddressType(entity.getAddressType());
		address.setLocality(entity.getLocality());
		address.setLandmark(entity.getLandmark());
		address.setLatitude(entity.getLatitude());
		address.setLongitude(entity.getLongitude());
		address.setPincode(entity.getPincode());
		address.setAddressObjectType(entity.getAddressObjectType());
		address.setObjectId(entity.getObjectId());
		address.setTitle(entity.getTitle());
		return addressRepository.save(address);

	}

	/**
	 * Delete the Address Entity Instance
	 * 
	 * @param id Id of the Address Entity Instance
	 * @throws ForUsExceptions
	 */
	@Override
	public void delete(Long id) {
		Address address = findOne(id);
		if (address != null) {
			address.setDeleted(true);
			addressRepository.save(address);
		} 
	}

	/**
	 * Get One Address Entity Instance
	 * 
	 * @param id Id of the Address Entity Instance
	 * @return Address Entity Instance
	 */
	@Override
	public Address findOne(Long id) {
		Address address = addressRepository.getOne(id);
		return address;

	}

	public List<Address> findAllUserAddress(String username) {
		return addressRepository.findAllUserAddress(userService.findUser(username).getId());
	}


	public Address findOneUserAddressByAddressType(String username, String addressType) {
		AddressType addressTypeObj = addressTypeRepository.findOneByAddressType(addressType);
		User user = userService.findUser(username);
		return addressRepository.findOneUserAddressByAddressType(user.getId(), addressTypeObj.getId());
	}

	public Address findOneAddressByObjectId(Long objectId) {
		return addressRepository.findOneAddressByObjectId(objectId);
	}

}
