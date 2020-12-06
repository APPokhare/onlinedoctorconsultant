package com.onlinedoctorconsultant.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedoctorconsultant.entities.info.Address;
import com.onlinedoctorconsultant.entities.info.Doctor;
import com.onlinedoctorconsultant.entities.info.Reviews;
import com.onlinedoctorconsultant.helpers.IBaseService;
import com.onlinedoctorconsultant.helpers.dto.DoctorDTO;
import com.onlinedoctorconsultant.repositories.DoctorRepository;

/**
 * @author Amruta 5th Dec 2020
 *
 */
@Service
public class DoctorService implements IBaseService<Doctor, Long> {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	ReviewsService reviewsService;

	@Autowired
	AddressService addressService;

	@Autowired
	UserService userService;

	/**
	 * Get All Doctor Entity List where deleted is false
	 * 
	 * @return List of Doctor Entity
	 */
	@Override
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}

	/**
	 * Save the Doctor Entity Instance
	 * 
	 * @param entity Instance of Doctor Entity
	 * @return New Created Instance of Doctor Entity
	 */
	@Override
	public Doctor save(Doctor entity) {
		return doctorRepository.save(entity);
	}

	/**
	 * Update the Doctor Entity Instance
	 * 
	 * @param id     Id of the Doctor Entity Instance
	 * @param entity Data to Update Doctor Entity Instance
	 * @return Update Doctor Entity Instance
	 * @throws ForUsExceptions
	 */
	@Override
	public Doctor update(Long id, Doctor entity) {
		Doctor doctor = findOne(id);
		doctor.setExp(entity.getExp());
		doctor.setLicense(entity.getLicense());
		doctor.setSpecialization(entity.getSpecialization());
		doctor.setUser(entity.getUser());

		return doctorRepository.save(doctor);
	}

	/**
	 * Delete the Doctor Entity Instance
	 * 
	 * @param id Id of the Doctor Entity Instance
	 * @throws ForUsExceptions
	 */
	@Override
	public void delete(Long id) {
		Doctor Doctor = findOne(id);
		Doctor.setDeleted(true);
		doctorRepository.save(Doctor);
	}

	/**
	 * Get One Doctor Entity Instance
	 * 
	 * @param id Id of the Doctor Entity Instance
	 * @return Doctor Entity Instance
	 */
	@Override
	public Doctor findOne(Long id) {
		Doctor Doctor = doctorRepository.getOne(id);
		return Doctor;

	}

	public List<Doctor> findAllBySpecilization(String specialization) {
		return doctorRepository.findAllBySpecilization(specialization);
	}

	public List<DoctorDTO> getAllNearbyDoctors(String specialization, String patientUsername) {

		List<DoctorDTO> listOfDoctorDTOs = new ArrayList<DoctorDTO>();

		List<Doctor> listOfDoctors = findAllBySpecilization(specialization);

		List<Long> listOfStars = new ArrayList<Long>();

		Map<Double, Double> mapOfStarsAndAddress = new HashMap<Double, Double>();

		Map<Long, Map<Double, Double>> map = new HashMap<Long, Map<Double, Double>>();

		Address addressOfPatient = 
				addressService.findOneAddressByObjectId(userService.findUser(patientUsername).getId());

		for(Doctor doctor : listOfDoctors) { 

			Address addressOfDoctor = 
					addressService.findOneAddressByObjectId(doctor.getUser().getId());

			List<Reviews> listOfReviews = reviewsService.findAllReviewsOfDoctor(doctor.getUser().getId());

			for(Reviews review : listOfReviews) 	
				listOfStars.add(review.getStars());

			Double stars = listOfStars.stream().mapToLong(i -> i).average().orElse(0);

			Double distance = distance(
					Double.parseDouble(addressOfPatient.getLatitude()), 
					Double.parseDouble(addressOfPatient.getLongitude()),
					Double.parseDouble(addressOfDoctor.getLatitude()), 
					Double.parseDouble(addressOfDoctor.getLongitude()));

			System.err.println("-------------------------------" + distance);

			mapOfStarsAndAddress.put(stars, distance);
			map.put(doctor.getUser().getId(), mapOfStarsAndAddress);
		}

		System.err.println("-------------------------------" + map.toString());

		int count = 1;
		int innerCount = 1;

		for(Map.Entry<Long, Map<Double, Double>> entry : map.entrySet()) {

			
			DoctorDTO doctorDTO = new DoctorDTO();
			doctorDTO.setId(entry.getKey());

			for(Map.Entry<Double, Double> innerEntry : entry.getValue().entrySet()) {
				
				if(count == innerCount) {
					doctorDTO.setStars(innerEntry.getKey());
					doctorDTO.setDistance(innerEntry.getValue());
				}
				innerCount++;
			}

			count++;
			innerCount = 1;
			listOfDoctorDTOs.add(doctorDTO);
		}

		Collections.sort(listOfDoctorDTOs, new Comparator<DoctorDTO>()  {

			@Override
			public int compare(DoctorDTO o1, DoctorDTO o2) {
				if(o1.getDistance().compareTo(o2.getDistance()) == 0) 
					return o2.getStars().compareTo(o1.getStars());
				else
					return o1.getDistance().compareTo(o2.getDistance());


			}
		});
		return listOfDoctorDTOs;
	}

	private double distance(double lat1, double lon1, double lat2, double lon2) {
		// haversine great circle distance approximation, returns meters
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
				* Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60; // 60 nautical miles per degree of seperation
		dist = dist * 1852; // 1852 meters per nautical mile
		return (dist);
	}
	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}

}
