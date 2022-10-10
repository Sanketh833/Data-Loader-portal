package com.cognizant.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	@Query(value = "SELECT * FROM patient.patient WHERE patient_email=?1", nativeQuery = true)
	public Patient getPatientDetails(String patient_email);
}
