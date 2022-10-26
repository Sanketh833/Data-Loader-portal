package com.cognizant.service;

import com.cognizant.dto.AdminDTO;
import com.cognizant.entity.AdminEntity;

public interface AdminServiceIntf {

	void createAdmin(AdminEntity adminentity);
 
	AdminEntity getAdmindetails(String username);

	void loginad(AdminEntity adminentity);

	 
	
	
	

}
