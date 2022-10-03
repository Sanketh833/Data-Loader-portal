package com.cognizant.service;

import org.springframework.http.ResponseEntity;

import com.cognizant.entity.Patient;

public interface PatientServiceIntf {

public	Patient createpatientdetails(Patient patient);

public Patient searchPatientByName(String patient_Name);

public Patient updatePatient(String patient_Name);

public Patient updatePatient(Patient patient, String patient_Name);

//public ResponseEntity<Patient> updatePatient(String patient_Name);
	
	

}
