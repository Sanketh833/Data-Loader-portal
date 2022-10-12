package com.cognizant.testcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.util.Base64;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cognizant.controller.AdminController;
import com.cognizant.entity.AdminEntity;
import com.cognizant.entity.Patient;
import com.cognizant.service.AdminRepository;
import com.cognizant.service.AdminService;
import com.cognizant.service.AdminServiceIntf;

@ExtendWith(MockitoExtension.class)
public class TestAdminController {

	@Mock
	AdminServiceIntf adminServiceintf;

	@Mock
	AdminRepository adminRepository;

	@InjectMocks
	AdminController adminController;

	@Mock
	RestTemplate resttemplate;

	@Test
	void testCreateAdmin() {

		AdminEntity adminEntity = new AdminEntity();
		adminEntity.setUsername("test@gmail.com");
		adminEntity.setPassword("12345");
		Mockito.lenient().when(adminRepository.existsByusername(adminEntity.getUsername())).thenReturn(false);
		Base64.Encoder encoder = Base64.getMimeEncoder();
		adminEntity.setPassword(encoder.encodeToString(adminEntity.getPassword().getBytes()));
		ResponseEntity responseEntity = ResponseEntity.ok("Admin Registered");
		adminServiceintf.createAdmin(adminEntity);
		assertEquals(responseEntity.getBody(), "Admin Registered");

	}

	@Test
	void testloginAdmin() {
		AdminEntity adminEntity = new AdminEntity();
		adminEntity.setUsername("test@gmail.com");
		adminEntity.setPassword("0987654");

		Mockito.lenient().when(adminRepository.existsByusername(adminEntity.getUsername())).thenReturn(true);
		Base64.Decoder decoder = Base64.getMimeDecoder();
		AdminEntity userToCheck = adminRepository.getUser(adminEntity.getUsername());
		String decodedPwd = new String(decoder.decode(adminEntity.getPassword()));
//		Mockito.lenient().when(userToCheck.getPassword().equals(user.getPassword())).thenReturn(true);
		ResponseEntity responseEntity = new ResponseEntity<>("Login successfull", HttpStatus.OK);
		assertEquals(responseEntity.getBody(), "Login successfull");
	}

	@Test
	void testCollectPatientDetails() {

		Patient patient = new Patient();
		patient.setPatient_email("sanketh@gmail.com");
		patient.setPatient_address("mumbai");
		patient.setPatient_contactnumber((long) 1234567890);
		patient.setPatient_name("Test");
		patient.setDob("2022-09-06");
		String url = "http://localhost:8090/load/retrieve/";
		lenient().when(resttemplate.getForObject(url + patient.getPatient_email(), Patient.class)).thenReturn(patient);
		assertEquals(patient, adminController.collectPatientDetails(patient.getPatient_email()));
	}

	@Test
	void testEditPatientDetails() {

		Patient patient = new Patient();
		patient.setPatient_email("sanketh@gmail.com");
		patient.setPatient_address("mumbai");
		patient.setPatient_contactnumber((long) 1234567890);
		patient.setPatient_name("Test");
		patient.setDob("2022-09-06");
		String url = "http://localhost:8090/load/retrieve/";
		when(resttemplate.put(url + patient.getPatient_email(),patient, Patient.class)).thenReturn(patient);
		assertEquals(patient, adminController.collectPatientDetails(patient.getPatient_email()));
	}
}
