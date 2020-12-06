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

import com.onlinedoctorconsultant.entities.info.Image;
import com.onlinedoctorconsultant.helpers.IBaseController;
import com.onlinedoctorconsultant.helpers.constants.IRestConstants;
import com.onlinedoctorconsultant.services.userinfo.ImageService;

/**
 * @author Amruta 5th Dec 2020
 * 
 * @endpoint /api/image
 *
 */
@RestController
@RequestMapping(IRestConstants.SEPARATOR + IRestConstants.API_BASE + IRestConstants.SEPARATOR + IRestConstants.IMAGE)
public class ImageController implements IBaseController<Image, Long>, IRestConstants {

	@Autowired
	ImageService imageService;
	
	/**
	 * GET - api/image
	 * 
	 * Get All Image Entity List where deleted is false
	 * 
	 * @return List of Image Entity
	 */
	@GetMapping()
	@Override
	public List<Image> findAll() {
		return imageService.findAll();
	}
	
	/**
	 * PUT - api/image
	 * 
	 * Save the Image Entity Instance
	 * 
	 * @param entity Instance of Image Entity
	 * @return New Created Image Entity Instance
	 */
	@PutMapping()
	@Override
	public Image save(@RequestBody Image entity) {
		return imageService.save(entity);
	}
	
	/**
	 * POST - api/image/{id}
	 * 
	 * Update the Image Entity Instance
	 * 
	 * @param id     Id of the Image Entity Instance
	 * @param entity Data to Update Image Entity Instance
	 * @return Update Image Entity Instance
	 * @throws ForUsExceptions
	 */
	@PostMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public Image update(@PathVariable(ID) Long id, @RequestBody Image entity) {
		return imageService.update(id, entity);
	}
	
	/**
	 * DELETE - api/image/{id}
	 * 
	 * Delete the Image Entity Instance
	 * 
	 * @param id Id of the Image Entity Instance
	 * @throws ForUsExceptions
	 */
	@DeleteMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public void delete(@PathVariable(ID) Long id) {
		imageService.delete(id);
	}
	
	/**
	 * GET - api/image/{id}
	 * 
	 * Get One Image Entity Instance
	 * 
	 * @param id Id of the Image Entity Instance
	 * @return Image Entity Instance
	 */
	@GetMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public Image findOne(@PathVariable(ID) Long id) {
		return imageService.findOne(id);
	}

}
