package com.creditmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	private Integer aid;
	private String area;
	private String city;
	private String district;
	private String state;
	private Integer pincode;
}
