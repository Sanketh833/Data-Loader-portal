package com.cognizant.testservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.entity.Patient;
import com.cognizant.service.PatientRepository;
import com.cognizant.service.PatientService;

@ExtendWith(MockitoExtension.class)
public class TestPatientService {

	@Mock
	PatientRepository patientRepository;

	@InjectMocks
	PatientService patientService;

	@Test
	void testsearchPatientByName() {

		Patient patient = new Patient();
		patient.setPatient_email("test@gmail.com");
		when(patientRepository.getPatientDetails(patient.getPatient_email())).thenReturn(patient);
		assertEquals(patient, patientService.searchPatientByName(patient.getPatient_email()));
	}

	@Test
	void testUpdatePatient() {

		Patient patient = new Patient();
		patient.setPatient_email("test@gmail.com");
		patient.setPatient_name("Test");
		patient.setPatient_address("Kurla,Mumbai");
		patient.setPatient_contactnumber((long) 1234567890);
		patient.setDob("2022-09-06");
		when(patientRepository.getPatientDetails(patient.getPatient_email())).thenReturn(patient);
		assertEquals(patient, patientService.updatePatient(patient, patient.getPatient_email()));
	}

}
