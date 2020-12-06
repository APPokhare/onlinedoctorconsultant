package com.onlinedoctorconsultant.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinedoctorconsultant.entities.info.User;
import com.onlinedoctorconsultant.helpers.IBaseRepository;

/**
 * @author Amruta 5th Dec 2020
 *
 */
@Repository
public interface UserRepository extends IBaseRepository<User, Long> {

	@Query("select a from User a where a.deleted = false")
	public List<User> findAll();

	@Query("select a from User a where a.id =:id and a.deleted = false")
	public User getOne(Long id);

	@Query("Select a from User a where a.username =:username and a.deleted = false")
	public User findUser(String username);
	
	
}
