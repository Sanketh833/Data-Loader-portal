package com.cognizant.service;

import java.util.Base64;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.dto.AdminDTO;
import com.cognizant.entity.AdminEntity;

@Service
public class AdminService implements AdminServiceIntf {

	@Autowired
	AdminRepository adminrepository;

	@Override
	public void createAdmin(@Valid AdminEntity adminentity) {
		
		 adminrepository.save(adminentity);
	} 

	@Override
	public AdminEntity getAdmindetails(String username) {
		 
		return adminrepository.getById(username);
	}

}
