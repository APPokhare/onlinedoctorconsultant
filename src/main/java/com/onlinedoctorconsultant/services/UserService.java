package com.onlinedoctorconsultant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedoctorconsultant.entities.info.User;
import com.onlinedoctorconsultant.helpers.IBaseService;
import com.onlinedoctorconsultant.repositories.UserRepository;

/**
 * @author Amruta 5th Dec 2020
 *
 */
@Service
public class UserService implements IBaseService<User, Long> {

	@Autowired
	UserRepository userRepository;

	/**
	 * Get All User Entity List where deleted is false
	 * 
	 * @return List of User Entity
	 */
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	/**
	 * Save the User Entity Instance
	 * 
	 * @param entity Instance of User Entity
	 * @return New Created Instance of User Entity
	 */
	@Override
	public User save(User entity) {
		return userRepository.save(entity);
	}

	/**
	 * Update the User Entity Instance
	 * 
	 * @param id     Id of the User Entity Instance
	 * @param entity Data to Update User Entity Instance
	 * @return Update User Entity Instance
	 * @throws ForUsExceptions
	 */
	@Override
	public User update(Long id, User entity) {
		User user = findOne(id);
		user.setEmail(entity.getEmail());
		user.setFirstName(entity.getFirstName());
		user.setLastName(entity.getLastName());
		user.setPassword(entity.getPassword());
		user.setMobile(entity.getMobile());
		user.setDob(entity.getDob());
		user.setGender(entity.getGender());
		user.setIsActive(entity.getIsActive());
		user.setUsername(entity.getUsername());
		user.setLastAccessDate(entity.getLastAccessDate());
		user.setImage(entity.getImage());
		
		return userRepository.save(user);
	}

	/**
	 * Delete the User Entity Instance
	 * 
	 * @param id Id of the User Entity Instance
	 * @throws ForUsExceptions
	 */
	@Override
	public void delete(Long id) {
		User user = findOne(id);
		user.setDeleted(true);
		userRepository.save(user);
	}

	/**
	 * Get One User Entity Instance
	 * 
	 * @param id Id of the User Entity Instance
	 * @return User Entity Instance
	 */
	@Override
	public User findOne(Long id) {
		User user = userRepository.getOne(id);

		return user;

	}

	public User findUser(String username) {
		User user = userRepository.findUser(username);
		return user;

	}

}
