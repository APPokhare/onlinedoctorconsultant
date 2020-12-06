package com.onlinedoctorconsultant.entities.info;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.onlinedoctorconsultant.entities.BaseEntity;
import com.onlinedoctorconsultant.helpers.constants.IRestConstants;

/**
 * @author Amruta 5th Dec 2020
 *
 */
@Entity
@Table(name = IRestConstants.REVIEWS)
public class Reviews extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@OneToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "doctor_id")
	private User doctorId;
	
	@Column(name = "stars")
	private Long stars;
	
	@Column(name = "comment")
	private String comment;

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
	 * @return the doctor
	 */
	public User getDoctor() {
		return doctorId;
	}

	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(User doctor) {
		this.doctorId = doctor;
	}


	/**
	 * @return the stars
	 */
	public Long getStars() {
		return stars;
	}

	/**
	 * @param stars the stars to set
	 */
	public void setStars(Long stars) {
		this.stars = stars;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((doctorId == null) ? 0 : doctorId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((stars == null) ? 0 : stars.hashCode());
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
		Reviews other = (Reviews) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (doctorId == null) {
			if (other.doctorId != null)
				return false;
		} else if (!doctorId.equals(other.doctorId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (stars == null) {
			if (other.stars != null)
				return false;
		} else if (!stars.equals(other.stars))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reviews [id=" + id + ", doctor=" + doctorId + ", stars=" + stars + ", comment="
				+ comment + "]";
	}
}
