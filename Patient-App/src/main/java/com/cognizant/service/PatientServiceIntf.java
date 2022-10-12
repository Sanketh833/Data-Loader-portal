package com.cognizant.service;

import org.springframework.http.ResponseEntity;

import com.cognizant.entity.Patient;

public interface PatientServiceIntf {
 
public Patient searchPatientByName(String patient_Email);
 
public Patient updatePatient(Patient patient, String patient_Email);
 
	

}
