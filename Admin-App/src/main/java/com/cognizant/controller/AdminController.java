package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cognizant.dto.AdminDTO;
import com.cognizant.entity.AdminEntity;
import com.cognizant.entity.Patient;
import com.cognizant.service.AdminServiceIntf;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminServiceIntf adminServiceIntf;

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/signup")
	public String createAdmin(@RequestBody AdminEntity adminentity) {

		adminServiceIntf.createAdmin(adminentity);
		return "Succesfully created Admin Account";
	}

	@PostMapping("/login")
	public boolean loginAdmin(@RequestBody AdminDTO adminDTO) {
		adminDTO.getUsername();
		adminDTO.getPassword();

		return adminServiceIntf.loginAdmin(adminDTO);
	}

	@GetMapping("/{username}/{patient_Name}")
	public AdminDTO collectPatientDetails(@PathVariable("username") String username,
			@PathVariable("patient_Name") String patient_Name) {
		AdminEntity adminEntity = adminServiceIntf.getAdmindetails(username);

		String url = "http://localhost:8090/load/retrieve/ ";

		Patient patient = this.restTemplate.getForObject(url + patient_Name, Patient.class);

		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setUsername(adminEntity.getUsername());
		adminDTO.setPassword(adminEntity.getPassword());
		adminDTO.setPatient(patient);
		return adminDTO;
	}
	

}
