package com.cognizant.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString; 

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer patientId;
	
	@NotBlank(message = "patient_Name cannot be empty")
	@Size(min = 5,max = 30)
	private String patient_Name;
	
	@NotBlank(message = "patient_Address need to be filled")
	private String patient_Address;
	
//	@NotBlank(message = "DOB cannot be null")
//	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date dob;
	
//	@NotNull(message = "patient_Email cannot be empty")
//	@Email( message =  "Enter valid patient_Email")
	private String patient_Email;
	
//	@NotBlank(message = "patient_ContactNumber cannot be empty")
//	@Size(min = 10, max = 10)
	private Integer patient_ContactNumber;
	
	@NotBlank(message = "drug_Id cannot be empty" )
	@NumberFormat(pattern = "XXXXX-XXXX-XX")
	private String drug_Id;
	
	@NotBlank(message = "drug_Name cannot be empty" )
	private String drug_Name;
	
}
