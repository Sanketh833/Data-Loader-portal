package com.cognizant.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cognizant.dto.AdminDTO;
import com.cognizant.entity.AdminEntity;
import com.cognizant.entity.Patient;
import com.cognizant.service.AdminRepository;
import com.cognizant.service.AdminServiceIntf;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	@Autowired
	AdminServiceIntf adminServiceIntf;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	AdminRepository adminrepository;

	@PostMapping("/signup")
	public ResponseEntity createAdmin(@RequestBody AdminEntity adminentity) {
 

		Base64.Encoder encoder = Base64.getMimeEncoder();

		if (adminrepository.existsByusername(adminentity.getUsername())) {
			return new ResponseEntity("Admin name already exist!Please enter different name", HttpStatus.OK);
		}
		adminentity.setPassword(encoder.encodeToString(adminentity.getPassword().getBytes()));
		adminServiceIntf.createAdmin(adminentity);

		return ResponseEntity.ok(adminentity);
	}

	@PostMapping("/login")
	public ResponseEntity loginAdmin(@RequestBody AdminEntity adminentity) {
//		 
		
		Base64.Decoder decoder = Base64.getMimeDecoder();  
		if (adminrepository.existsByusername(adminentity.getUsername())) {
			AdminEntity existingUser = adminrepository.getUser(adminentity.getUsername());
			String decodedPwd = new String (decoder.decode(existingUser.getPassword()));
			if (decodedPwd.equals(adminentity.getPassword())) {
				return new ResponseEntity(existingUser,HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Entered Password is wrong",HttpStatus.OK);
			}
		}
		return new ResponseEntity("Entered UserName is wrong",HttpStatus.OK);
	}

	@GetMapping("/get/{patient_Email}")
	public Patient collectPatientDetails(@PathVariable("patient_Email") String patient_Email) {

		String url = "http://localhost:8090/load/retrieve/ ";

		Patient patient = this.restTemplate.getForObject(url + patient_Email, Patient.class);

		return patient;
	}

//	@GetMapping("/{username}/{patient_Name}")
//	public AdminDTO collectPatientDetails(@PathVariable("username") String username,
//			@PathVariable("patient_Name") String patient_Name) {
//		AdminEntity adminEntity = adminServiceIntf.getAdmindetails(username);
//
//		String url = "http://localhost:8090/load/retrieve/ ";
//
//		Patient patient = this.restTemplate.getForObject(url + patient_Name, Patient.class);
//
//		AdminDTO adminDTO = new AdminDTO();
//		adminDTO.setUsername(adminEntity.getUsername());
//		adminDTO.setPassword(adminEntity.getPassword());
//		adminDTO.setPatient(patient);
//		return adminDTO;
//	}

	@PutMapping("/edit/{patient_email}")
	public void editPatientDetails(@RequestBody Patient patient, 
			@PathVariable("patient_email") String patient_email) {
		String url = "http://localhost:8090/load/update/";
		this.restTemplate.put(url + patient_email, patient, Patient.class);

	}

}
