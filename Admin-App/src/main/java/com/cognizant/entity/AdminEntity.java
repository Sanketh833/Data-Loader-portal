package com.cognizant.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class AdminEntity {

	@Id 
	@NotBlank(message = "username cannot be blank" )
	@Email(message = "user name should be a valid email")
	private String username;
	@NotBlank(message = "password cannot be blank" )
	
	private String password;
	 
	
	
}
