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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

	 @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long patient_id;

//	@NotBlank(message = "patient_Name cannot be empty")
//	@Size(min = 5,max = 30)
	private String patient_name;

//	@NotBlank(message = "patient_Address need to be filled")
	private String patient_address;

//	@NotBlank(message = "DOB cannot be null")
//	@DateTimeFormat(pattern = "MM-DD-YYYY")
	private String dob;

//	@NotNull(message = "patient_Email cannot be empty")
//	@Email( message =  "Enter valid patient_Email")
	private String patient_email;

//	@NotBlank(message = "patient_ContactNumber cannot be empty")
//	@Size(min = 10, max = 10)
	private Long patient_contactnumber;

//	@NotBlank(message = "drug_Id cannot be empty" )
//	@NumberFormat(pattern = "XXXXX-XXXX-XX")
	private Integer drug_id;

//	@NotBlank(message = "drug_Name cannot be empty" )
	private String drug_name;

	 
}