package com.alpha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Enquiry {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "abc", sequenceName = "enquiry_sequence",initialValue = 1 , allocationSize = 1)
	@GeneratedValue(generator = "abc", strategy = GenerationType.AUTO)
	private Integer custId;
	
	@Column(name = "name")
	private String customerName;
	
	@Column(name = "pancard")
	private String pancardNumber;
	
	@Column(name = "mobileno")
	private long customerMobileNumber;
	
	@Column(name = "emailid")
	private String customerEmailId;
	
	@Column(name = "Age")
	private String age;
	
	@Column(name = "status")
	private String enquiryStatus;
	
	private Integer cibil;
}
