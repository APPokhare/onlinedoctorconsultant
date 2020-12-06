package com.onlinedoctorconsultant.controllers;

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

import com.onlinedoctorconsultant.entities.info.Reviews;
import com.onlinedoctorconsultant.helpers.IBaseController;
import com.onlinedoctorconsultant.helpers.constants.IRestConstants;
import com.onlinedoctorconsultant.services.ReviewsService;

/**
 * @author Amruta 5th Dec 2020
 *
 * @endpoint /api/Reviews
 *
 */
@RestController
@RequestMapping(IRestConstants.SEPARATOR + IRestConstants.API_BASE + IRestConstants.SEPARATOR + IRestConstants.REVIEWS)
public class ReviewsController implements IBaseController<Reviews, Long>, IRestConstants {

	@Autowired
	ReviewsService reviewsService;

	/**
	 * GET - api/Reviews
	 * 
	 * Get All Reviews Entity List where deleted is false
	 * 
	 * @return List of Entity
	 */
	@GetMapping()
	@Override
	public List<Reviews> findAll() {
		return reviewsService.findAll();
	}

	/**
	 * PUT - api/Reviews
	 * 
	 * Save the Reviews Entity Instance
	 * 
	 * @param entity Instance of Reviews Entity
	 * @return New Created Instance of Reviews Entity
	 */
	@PutMapping()
	@Override
	public Reviews save(@RequestBody Reviews entity) {
		return reviewsService.save(entity);
	}

	/**
	 * POST - api/Reviews/{id}
	 * 
	 * Update the Reviews Entity Instance
	 * 
	 * @param id     Id of the Reviews Entity Instance
	 * @param entity Data to Update Reviews Entity Instance
	 * @return Update Reviews Entity Instance
	 * @throws ForUsExceptions
	 */
	@PostMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public Reviews update(@PathVariable(ID) Long id, @RequestBody Reviews entity) {
		return reviewsService.update(id, entity);
	}

	/**
	 * DELETE - api/Reviews/{id}
	 * 
	 * Delete the Reviews Entity Instance
	 * 
	 * @param id Id of the Reviews Entity Instance
	 * @throws ForUsExceptions
	 */
	@DeleteMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public void delete(@PathVariable(ID) Long id) {
		reviewsService.delete(id);
	}

	/**
	 * GET - api/Reviews/{id}
	 * 
	 * Get One Reviews Entity Instance
	 * 
	 * @param id Id of the Reviews Entity Instance
	 * @return Entity Instance
	 */
	@GetMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public Reviews findOne(@PathVariable(ID) Long id) {
		return reviewsService.findOne(id);
	}
}
