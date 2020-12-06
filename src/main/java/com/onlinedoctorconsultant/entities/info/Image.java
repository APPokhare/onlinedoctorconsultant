package com.onlinedoctorconsultant.entities.info;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.onlinedoctorconsultant.entities.BaseEntity;
import com.onlinedoctorconsultant.helpers.constants.IRestConstants;

/**
 * @author Amruta 5th Dec 2020
 *
 */

@Entity
@Table(name = IRestConstants.IMAGE)
public class Image extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "image_name")
	private String imageName;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "image_latitude")
	private String imageLatitude;
	
	@Column(name = "image_longitude")
	private String imageLongitude;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the imageName
	 */
	public String getImageName() {
		return imageName;
	}

	/**
	 * @param imageName the imageName to set
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	/**
	 * @return the imagePath
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the imageLatitude
	 */
	public String getImageLatitude() {
		return imageLatitude;
	}

	/**
	 * @param imageLatitude the imageLatitude to set
	 */
	public void setImageLatitude(String imageLatitude) {
		this.imageLatitude = imageLatitude;
	}

	/**
	 * @return the imageLongitude
	 */
	public String getImageLongitude() {
		return imageLongitude;
	}

	/**
	 * @param imageLongitude the imageLongitude to set
	 */
	public void setImageLongitude(String imageLongitude) {
		this.imageLongitude = imageLongitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imageLatitude == null) ? 0 : imageLatitude.hashCode());
		result = prime * result + ((imageLongitude == null) ? 0 : imageLongitude.hashCode());
		result = prime * result + ((imageName == null) ? 0 : imageName.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Image other = (Image) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imageLatitude == null) {
			if (other.imageLatitude != null)
				return false;
		} else if (!imageLatitude.equals(other.imageLatitude))
			return false;
		if (imageLongitude == null) {
			if (other.imageLongitude != null)
				return false;
		} else if (!imageLongitude.equals(other.imageLongitude))
			return false;
		if (imageName == null) {
			if (other.imageName != null)
				return false;
		} else if (!imageName.equals(other.imageName))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		return true;
	}
	
	
}
