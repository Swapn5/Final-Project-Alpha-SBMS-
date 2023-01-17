package com.alpha.model;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enquiry {


	private int custId;
	
	private String customerName;
	
	private String pancardNumber;
	
	private long customerMobileNumber;
	
	private String customerEmailId;
	
	private String age;
	
	private String enquiryStatus;
	
	private Integer cibil;
}
