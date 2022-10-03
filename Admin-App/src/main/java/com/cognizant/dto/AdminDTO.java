package com.cognizant.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.cognizant.entity.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class AdminDTO { 
	 
	@NotBlank(message = "username cannot be blank" )
	@Email(message = "user name should be a valid email")
	private String username;
	private String password;
	private Patient patient;
}
