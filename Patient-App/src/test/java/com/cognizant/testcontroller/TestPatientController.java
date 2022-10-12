package com.cognizant.testcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant.controller.PatientController;
import com.cognizant.entity.Patient;
import com.cognizant.service.PatientService;
import com.cognizant.service.PatientServiceIntf;

@ExtendWith(MockitoExtension.class)
public class TestPatientController {

	@Mock
	PatientServiceIntf patientServiceintf;

	@InjectMocks
	PatientController patientController;

	@Test
	void searchPatientByName() {
		Patient patient = new Patient();
		patient.setPatient_email("test@gmail.com");
		when(patientServiceintf.searchPatientByName(patient.getPatient_email())).thenReturn(patient);
		assertEquals(patient, patientController.searchPatientByName(patient.getPatient_email()));

	}

	@Test
	void updatePatientDetails() {
		
		 Patient patient= new Patient();
		patient.setPatient_email("test@gmail.com");
		patient.setPatient_name("Test");
		patient.setPatient_address("Kurla,Mumbai");
		patient.setPatient_contactnumber((long) 1234567890);
		patient.setDob("2022-09-06");
		when(patientServiceintf.updatePatient(patient, patient.getPatient_email())).thenReturn(patient);
		assertEquals(new ResponseEntity<>(patient, HttpStatus.OK) , patientController.updatePatientDetails(patient.getPatient_email(), patient));
	}

}
