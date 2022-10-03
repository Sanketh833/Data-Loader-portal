package com.cognizant.service;
 
import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.entity.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, String> {

}
