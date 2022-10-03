package com.cognizant.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.Patient;
import com.cognizant.service.PatientServiceIntf;

@RestController
@RequestMapping("/load")
public class PatientController {

	@Autowired
	PatientServiceIntf patientServiceIntf;

	@PostMapping("/patientdata")
	public Patient createpatientdetails(@Valid @RequestBody Patient patient) {
		return patientServiceIntf.createpatientdetails(patient);
	}

	@GetMapping("/retrieve/{patient_Name}")
	public Patient searchPatientByName(@PathVariable String patient_Name) {
		Patient patientresponse = patientServiceIntf.searchPatientByName(patient_Name);
		return patientresponse;
	}

	@PutMapping("/update/{patient_Name}")
	public ResponseEntity<Patient> updatePatientDetails(@PathVariable("patient_Name") String patient_Name
			,@RequestBody Patient patient) {

		return new ResponseEntity<Patient>(patientServiceIntf.updatePatient(patient, patient_Name), HttpStatus.OK);

	}

}
