package com.alpha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	private Integer eid;
	private String firstName;
	private String lastName;
	private String role;
	private String email;
	private byte[] profile;
}
