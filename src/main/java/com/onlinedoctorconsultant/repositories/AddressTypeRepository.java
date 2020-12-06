package com.onlinedoctorconsultant.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinedoctorconsultant.entities.info.AddressType;
import com.onlinedoctorconsultant.helpers.IBaseRepository;

/**
 * @author Amruta 5th Dec 2020
 */
@Repository
public interface AddressTypeRepository extends IBaseRepository<AddressType, Long>{

	@Query("select a from AddressType a where a.deleted = false")
	public List<AddressType> findAll();

	@Query("select a from AddressType a where a.id =:id and a.deleted = false")
	public AddressType getOne(Long id);
	
	@Query("select a from AddressType a where a.addressType =:addressType and a.deleted = false")
	public AddressType findOneByAddressType(String addressType);
	
}
