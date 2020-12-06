package com.onlinedoctorconsultant.services.userinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedoctorconsultant.entities.info.Reviews;
import com.onlinedoctorconsultant.helpers.IBaseService;
import com.onlinedoctorconsultant.repositories.userinfo.ReviewsRepository;

/**
 * @author Amruta 5th Dec 2020
 *
 */
@Service
public class ReviewsService implements IBaseService<Reviews, Long> {

	@Autowired
	ReviewsRepository reviewsRepository;

	/**
	 * Get All Reviews Entity List where deleted is false
	 * 
	 * @return List of Reviews Entity
	 */
	@Override
	public List<Reviews> findAll() {
		return reviewsRepository.findAll();
	}

	/**
	 * Save the Reviews Entity Instance
	 * 
	 * @param entity Instance of Reviews Entity
	 * @return New Created Instance of Reviews Entity
	 */
	@Override
	public Reviews save(Reviews entity) {
		return reviewsRepository.save(entity);
	}

	/**
	 * Update the Reviews Entity Instance
	 * 
	 * @param id     Id of the Reviews Entity Instance
	 * @param entity Data to Update Reviews Entity Instance
	 * @return Update Reviews Entity Instance
	 * @throws ForUsExceptions
	 */
	@Override
	public Reviews update(Long id, Reviews entity) {
		Reviews reviews = findOne(id);
		reviews.setDoctor(entity.getDoctor());
		reviews.setReviews(entity.getReviews());
		
		
		return reviewsRepository.save(reviews);
	}

	/**
	 * Delete the Reviews Entity Instance
	 * 
	 * @param id Id of the Reviews Entity Instance
	 * @throws ForUsExceptions
	 */
	@Override
	public void delete(Long id) {
		Reviews Reviews = findOne(id);
		Reviews.setDeleted(true);
		reviewsRepository.save(Reviews);
	}

	/**
	 * Get One Reviews Entity Instance
	 * 
	 * @param id Id of the Reviews Entity Instance
	 * @return Reviews Entity Instance
	 */
	@Override
	public Reviews findOne(Long id) {
		Reviews Reviews = reviewsRepository.getOne(id);

		return Reviews;

	}


}
