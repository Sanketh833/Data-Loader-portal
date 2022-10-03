package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.entity.Patient;
import com.cognizant.exception.ResourceNotFoundException;

@Service
public class PatientService implements PatientServiceIntf {

	@Autowired
	PatientRepository patientRepository;

	@Override
	public Patient createpatientdetails(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Patient searchPatientByName(String patient_Name) {

		Patient response = patientRepository.getPatientDetails(patient_Name);
		return response;
	}

	@Override
	public Patient updatePatient(String patient_Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient updatePatient(Patient patient, String patient_Name) {
		Patient existingPatient = patientRepository.getPatientDetails(patient_Name);
		 
		 existingPatient.setPatient_Email(patient.getPatient_Name());
		 existingPatient.setPatient_Address(patient.getPatient_Address());
		 existingPatient.setPatient_ContactNumber(patient.getPatient_ContactNumber());
		 existingPatient.setPatient_Name(patient.getPatient_Name());
		 existingPatient.setDob(patient.getDob());
		 patientRepository.save(existingPatient);
		 return existingPatient;
	}

	 

}
