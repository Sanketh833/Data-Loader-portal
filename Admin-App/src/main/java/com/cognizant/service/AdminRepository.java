package com.cognizant.service;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.entity.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, String> {

	
	@Query(value = "SELECT * FROM admin.admin_entity where username=?1", nativeQuery = true)
	public AdminEntity getUser(@Param("username") String username);
	
	Boolean existsByusername(String userName);
}
