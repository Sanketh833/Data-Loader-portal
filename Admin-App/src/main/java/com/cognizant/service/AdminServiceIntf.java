package com.cognizant.service;

import com.cognizant.dto.AdminDTO;
import com.cognizant.entity.AdminEntity;

public interface AdminServiceIntf {

	void createAdmin(AdminEntity adminentity);

	boolean loginAdmin(AdminDTO adminDTO);

	AdminEntity getAdmindetails(String username);

	 
	
	
	

}
