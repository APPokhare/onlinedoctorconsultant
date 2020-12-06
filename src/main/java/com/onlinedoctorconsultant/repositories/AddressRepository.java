package com.onlinedoctorconsultant.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinedoctorconsultant.entities.info.Address;
import com.onlinedoctorconsultant.helpers.IBaseRepository;

/**
 * @author Amruta 5th Dec 2020
 */
@Repository
public interface AddressRepository extends IBaseRepository<Address, Long>{

	@Query("select a from Address a where a.deleted = false")
	public List<Address> findAll();

	@Query("select a from Address a where a.id =:id and a.deleted = false")
	public Address getOne(Long id);
	
	@Query("select a from Address a where a.objectId =:objectId and a.deleted = false")
	public List<Address> findAllUserAddress(Long objectId);
	
	@Query("select a from Address a where a.objectId =:objectId and a.addressType=:addressType")
	public Address findOneUserAddressByAddressType(Long objectId, Long addressType);
	
	@Query("select a from Address a where a.objectId =:objectId and a.deleted = false")
	public Address findAllUserPostAddress(Long objectId);
	
	@Query("select a from Address a where a.objectId =:objectId and a.deleted = false")
	public Address findOneAddressByObjectId(Long objectId);
	
}
