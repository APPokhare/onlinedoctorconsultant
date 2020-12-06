package com.onlinedoctorconsultant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.onlinedoctorconsultant" })
public class OnlineDoctorConsultantSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineDoctorConsultantSpringApplication.class, args);
	}

}
