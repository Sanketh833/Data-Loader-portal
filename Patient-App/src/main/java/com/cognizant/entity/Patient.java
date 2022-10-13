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
@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long patient_id;

	@NotNull(message = "patient_Name cannot be empty")
//	@Size(min = 5,max = 30)
	private String patient_name;

	@NotNull(message = "patient_Address need to be filled")
	private String patient_address;

	@NotNull(message = "DOB cannot be null")
//	@DateTimeFormat(pattern = "MM-DD-YYYY")
	
	private String dob;

//	@NotBlank(message = "patient contact cannot be null")
	@NotNull(message = "patient_Email cannot be empty")
	@Email( message =  "Enter valid patient_Email")
	private String patient_email;

//	@NotBlank(message = "patient contact cannot be null")
	@NotNull(message = "patient_ContactNumber cannot be empty")
//	@Size(min = 10, max = 10)
	private Long patient_contactnumber;

	@NotNull(message = "drug_Id cannot be empty" )
//	@NumberFormat(pattern = "XXXXX-XXXX-XX")
	private Integer drug_id;

	@NotNull(message = "drug_Name cannot be empty" )
	private String drug_name;

	public Patient() {
		super();
	}

	public Patient(Long patient_id, String patient_name, String patient_address, String dob, String patient_email,
			Long patient_contactnumber, Integer drug_id, String drug_name) {
		super();
		this.patient_id = patient_id;
		this.patient_name = patient_name;
		this.patient_address = patient_address;
		this.dob = dob;
		this.patient_email = patient_email;
		this.patient_contactnumber = patient_contactnumber;
		this.drug_id = drug_id;
		this.drug_name = drug_name;
	}

}
