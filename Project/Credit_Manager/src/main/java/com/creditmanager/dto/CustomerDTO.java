package com.creditmanager.dto;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import com.creditmanager.model.Address;
import com.creditmanager.model.CarInfo;
import com.creditmanager.model.Guarantor;
import com.creditmanager.model.LoanDetails;
import com.creditmanager.model.PreviousLoanDetails;
import com.creditmanager.model.Profession;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
	
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

	

	
	
}
