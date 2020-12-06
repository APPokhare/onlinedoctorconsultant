package com.onlinedoctorconsultant.repositories.userinfo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinedoctorconsultant.entities.info.Pincode;
import com.onlinedoctorconsultant.helpers.IBaseRepository;

/**
 * @author Amruta 5th Dec 2020
 */
@Repository
public interface PincodeRepository extends IBaseRepository<Pincode, Long>{

	@Query("select a from Pincode a where a.deleted = false")
	public List<Pincode> findAll();

	@Query("select a from Pincode a where a.id =:id and a.deleted = false")
	public Pincode getOne(Long id);
	
	@Query("select a from Pincode a where a.pincode =:pincode and a.deleted = false")
	public Pincode findOneByPincode(String pincode);
	
}
