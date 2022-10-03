package com.cognizant.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	@Query(value = "SELECT * FROM patient.patient WHERE patient_name=?1", nativeQuery = true)
	public Patient getPatientDetails(String patient_Name);
}
