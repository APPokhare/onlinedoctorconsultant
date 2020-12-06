package com.onlinedoctorconsultant.controllers.userinfo;

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

import com.onlinedoctorconsultant.entities.info.User;
import com.onlinedoctorconsultant.helpers.IBaseController;
import com.onlinedoctorconsultant.helpers.constants.IRestConstants;
import com.onlinedoctorconsultant.services.userinfo.UserService;

/**
 * @author Amruta 5th Dec 2020
 *
 * @endpoint /api/user
 *
 */
@RestController
@RequestMapping(IRestConstants.SEPARATOR + IRestConstants.API_BASE + IRestConstants.SEPARATOR + IRestConstants.USER)
public class UserController implements IBaseController<User, Long>, IRestConstants {

	@Autowired
	UserService userService;

	/**
	 * GET - api/user
	 * 
	 * Get All User Entity List where deleted is false
	 * 
	 * @return List of Entity
	 */
	@GetMapping()
	@Override
	public List<User> findAll() {
		return userService.findAll();
	}

	/**
	 * PUT - api/user
	 * 
	 * Save the User Entity Instance
	 * 
	 * @param entity Instance of User Entity
	 * @return New Created Instance of User Entity
	 */
	@PutMapping()
	@Override
	public User save(@RequestBody User entity) {
		return userService.save(entity);
	}

	/**
	 * POST - api/user/{id}
	 * 
	 * Update the User Entity Instance
	 * 
	 * @param id     Id of the User Entity Instance
	 * @param entity Data to Update User Entity Instance
	 * @return Update User Entity Instance
	 * @throws ForUsExceptions
	 */
	@PostMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public User update(@PathVariable(ID) Long id, @RequestBody User entity) {
		return userService.update(id, entity);
	}

	/**
	 * DELETE - api/user/{id}
	 * 
	 * Delete the User Entity Instance
	 * 
	 * @param id Id of the User Entity Instance
	 * @throws ForUsExceptions
	 */
	@DeleteMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public void delete(@PathVariable(ID) Long id) {
		userService.delete(id);
	}

	/**
	 * GET - api/user/{id}
	 * 
	 * Get One User Entity Instance
	 * 
	 * @param id Id of the User Entity Instance
	 * @return Entity Instance
	 */
	@GetMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public User findOne(@PathVariable(ID) Long id) {
		return userService.findOne(id);
	}

}
