package com.onlinedoctorconsultant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedoctorconsultant.entities.info.Image;
import com.onlinedoctorconsultant.helpers.IBaseService;
import com.onlinedoctorconsultant.repositories.ImageRepository;

/**
 * @author Amruta 5th Dec 2020
 */
@Service
public class ImageService implements IBaseService<Image, Long> {

	@Autowired
	ImageRepository imageRepository;

	/**
	 * Get All Image Entity List where deleted is false
	 * 
	 * @return List of Image Entity
	 */
	@Override
	public List<Image> findAll() {
		return imageRepository.findAll();
	}

	/**
	 * Save the Image Entity Instance
	 * 
	 * @param entity Instance of Image Entity
	 * @return New Created Image Entity Instance
	 */
	@Override
	public Image save(Image entity) {
		return imageRepository.save(entity);
	}

	/**
	 * Update the Image Entity Instance
	 * 
	 * @param id     Id of the Image Entity Instance
	 * @param entity Data to Update Image Entity Instance
	 * @return Update Entity Image Entity
	 * @throws ForUsExceptions
	 */
	@Override
	public Image update(Long id, Image entity) {
		Image image = findOne(id);
		image.setImageName(entity.getImageName());
		image.setImageUrl(entity.getImageUrl());
		image.setImageLatitude(entity.getImageLatitude());
		image.setImageLongitude(entity.getImageLongitude());
		return imageRepository.save(image);
	}

	/**
	 * Delete the Image Entity Instance
	 * 
	 * @param id Id of the Image Entity Instance
	 * @throws ForUsExceptions
	 */
	@Override
	public void delete(Long id) {
		Image image = findOne(id);
		image.setDeleted(true);
		imageRepository.save(image);
	}

	/**
	 * Get One Image Entity Instance
	 * 
	 * @param id Id of the Image Entity Instance
	 * @return Image Entity Instance
	 */
	@Override
	public Image findOne(Long id) {
		Image image = imageRepository.getOne(id);
		return image;
	}

}
