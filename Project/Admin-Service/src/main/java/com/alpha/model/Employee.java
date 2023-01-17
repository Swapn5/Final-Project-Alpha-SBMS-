package com.alpha.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
	
	@Id
	@SequenceGenerator(name = "abc",sequenceName = "employee_sequence", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "abc", strategy = GenerationType.AUTO)
	private Integer eid;
	private String firstName;
	private String lastName;
	private char[] password;
	private String role;
	private String email;
	private String gender;
	private String birthDate;
}

