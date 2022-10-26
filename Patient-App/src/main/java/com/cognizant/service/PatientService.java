package com.cognizant.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.entity.Patient;
import com.cognizant.exception.ResourceNotFoundException;

@Service
public class PatientService implements PatientServiceIntf {

	@Autowired
	PatientRepository patientRepository;

	@Override
	public Patient searchPatientByName(String patient_Email) {
		Patient response = patientRepository.getPatientDetails(patient_Email);
		return response;
	}

	@Override
	@Transactional(rollbackFor = java.sql.SQLException.class)
	public Patient updatePatient(Patient patient, String patient_email) {
		Patient existingPatient = patientRepository.getPatientDetails(patient_email);

		existingPatient.setPatient_address(patient.getPatient_address());
		existingPatient.setPatient_contactnumber(patient.getPatient_contactnumber());
		existingPatient.setPatient_name(patient.getPatient_name());
		existingPatient.setDob(patient.getDob());
		existingPatient.setStatus("Approved");
		patientRepository.save(existingPatient);
		
		return existingPatient;
	}

}
