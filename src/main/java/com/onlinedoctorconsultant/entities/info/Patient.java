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
@Table(name = IRestConstants.PATIENT)
public class Patient extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@OneToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "medicalHistory")
	private String medicalHistory;

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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the medicalHistory
	 */
	public String getMedicalHistory() {
		return medicalHistory;
	}

	/**
	 * @param medicalHistory the medicalHistory to set
	 */
	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((medicalHistory == null) ? 0 : medicalHistory.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Patient other = (Patient) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (medicalHistory == null) {
			if (other.medicalHistory != null)
				return false;
		} else if (!medicalHistory.equals(other.medicalHistory))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", user=" + user + ", medicalHistory=" + medicalHistory + "]";
	}
	
}
