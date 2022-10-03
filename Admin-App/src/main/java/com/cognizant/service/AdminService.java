package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.dto.AdminDTO;
import com.cognizant.entity.AdminEntity;

@Service
public class AdminService implements AdminServiceIntf {

	@Autowired
	AdminRepository adminrepository;

	@Override
	public void createAdmin(AdminEntity adminentity) {

		adminrepository.save(adminentity);
	}

	@Override
	public boolean loginAdmin(AdminDTO adminDTO) {

		adminDTO.getUsername();
		adminDTO.getPassword();
		AdminEntity adminEntity = adminrepository.findById(adminDTO.getUsername()).get();
		if(adminEntity != null && adminEntity.getPassword().equals(adminDTO.getPassword())) {
			return true;

		}
		return false;

	}

	@Override
	public AdminEntity getAdmindetails(String username) {
		 
		return adminrepository.getById(username);
	}

}
