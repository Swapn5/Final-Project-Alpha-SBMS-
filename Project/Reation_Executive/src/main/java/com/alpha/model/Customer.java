package com.alpha.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@SequenceGenerator(name = "abc", sequenceName = "customer_sequence",initialValue = 500000 , allocationSize = 1)
	@GeneratedValue(generator = "abc" , strategy = GenerationType.AUTO)
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
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Profession proff;
		
	@OneToOne(cascade = CascadeType.ALL)
	private LoanDetails loan;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Guarantor guarantor;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CarInfo car;
		
}
