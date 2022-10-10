package com.cognizant.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cognizant.entity.Patient;
import com.cognizant.uploadfile.CSVFileUpload;

@Service
public class CSVService {
	
	
	@Autowired
	PatientRepository repository;
	
	
	
	public void save(MultipartFile file) {
		 System.out.println("call at save");
	    try {
	      List<Patient> patientslist = CSVFileUpload.csvToPatient(file.getInputStream());
	      System.out.println("dfgh");
	      patientslist.forEach(System.out::println);
	      System.out.println("dfghj");
//	      System.out.println(patientslist);
//	      repository.saveAll(patientslist);
	      repository.saveAll(patientslist);
	      System.out.println("call after repo");
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }

	  public List<Patient> getPatients() {
	    return repository.findAll();
	  }

}

 
