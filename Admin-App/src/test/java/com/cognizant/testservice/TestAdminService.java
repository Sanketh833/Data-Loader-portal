package com.cognizant.testservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.entity.AdminEntity;
import com.cognizant.service.AdminRepository;
import com.cognizant.service.AdminService; 

@ExtendWith(MockitoExtension.class)
public class TestAdminService {
	
	@Mock
	AdminRepository adminRepository;

	@InjectMocks
	AdminService adminService;
	
	
	@Test
	void testCreateAdmin() {
		AdminEntity adminEntity = new AdminEntity();
		adminEntity.setUsername("test@gmail.com"); 
		adminEntity.setPassword("12345678"); 
		Mockito.lenient().when(adminRepository.save(adminEntity)).thenReturn(adminEntity);
		assertEquals(adminEntity.getUsername(), "test@gmail.com");

}
	
	@Test
	void testGetAdmindetails() {
		AdminEntity adminEntity = new AdminEntity();
		adminEntity.setUsername("test@gmail.com");
		when(adminRepository.getById(adminEntity.getUsername())).thenReturn(adminEntity);
		assertEquals(adminEntity, adminService.getAdmindetails(adminEntity.getUsername()));
		
	}
}