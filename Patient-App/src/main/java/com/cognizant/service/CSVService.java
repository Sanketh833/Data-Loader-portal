package com.cognizant.service;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cognizant.entity.Patient;
import com.cognizant.uploadfile.CSVFileUpload;

@Service
public class CSVService {
	
	
	@Autowired
	PatientRepository repository;
	
	
//	@Transactional("rollbackFor = java.sql.SQLException")
	public void save(  MultipartFile file) { 
	    try {
	      List<Patient> patientslist = CSVFileUpload.csvToPatient(file.getInputStream()); 
	      patientslist.forEach(System.out::println); 
	      System.out.println(patientslist);
//	      repository.saveAll(patientslist);
	      repository.saveAll(patientslist); 
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }

	  public List<Patient> getPatients() {
	    return repository.findAll();
	  }

}

 
