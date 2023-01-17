package com.alpha.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee 
{
	@Id
	private int eid;
	private String firstName;
	private String lastName;
	private String  password;
	private String  role;
	private String  email;
	private String  gender;
	private String  birthday;
	private byte[]  Profile;

}
