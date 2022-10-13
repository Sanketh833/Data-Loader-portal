package com.cognizant.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cognizant.entity.Patient;
import com.cognizant.message.message;
import com.cognizant.service.CSVService;
import com.cognizant.service.PatientServiceIntf;
import com.cognizant.uploadfile.CSVFileUpload;

@RestController
@RequestMapping("/load")
@CrossOrigin
public class PatientController {

	@Autowired
	PatientServiceIntf patientServiceIntf;

	@Autowired
	CSVService csvservice;

	@PostMapping("/upload")
	public ResponseEntity<message> uploadFile( @RequestParam(value = "file") MultipartFile file) {
		String message = "";
		if (CSVFileUpload.hasCSVFormat(file)) {
			try {
				csvservice.save(file);
				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new message(message));
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new message(message));
			}
		}

		message = "Please upload a csv file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new message(message));
	}

	@GetMapping("/retrieve/{patient_email}")
	public Patient searchPatientByName(@PathVariable String patient_email) {
		Patient patientresponse = patientServiceIntf.searchPatientByName(patient_email);
		return patientresponse;
	}

	@PutMapping("/update/{patient_email}")
	public ResponseEntity<Patient> updatePatientDetails(@PathVariable("patient_email") String patient_email,
			@RequestBody Patient patient) {

		return new ResponseEntity<Patient>(patientServiceIntf.updatePatient(patient, patient_email), HttpStatus.OK);

	}

}
