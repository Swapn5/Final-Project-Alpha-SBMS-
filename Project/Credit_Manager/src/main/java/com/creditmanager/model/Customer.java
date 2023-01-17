package com.creditmanager.model;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	private int cid;
	
	private String cname;
	
	private String birthDate;
	
	private String gender;
	
	private String maritalStatus;
	
	private Long loanAmount;
	
	private String email;
	
	private Long mobile;
	
	private String pan;
	
	private String adhar;
	
	private Address address;
	
	private Profession proff;
		
	private LoanDetails loan;
	
	private Guarantor guarantor;
	
	private CarInfo car;

	
}
