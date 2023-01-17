package com.alpha.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@SequenceGenerator(name = "abc", sequenceName = "customer_sequence",initialValue = 5000 , allocationSize = 1)
	@GeneratedValue(generator = "abc" , strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int customerId;
	
	@Column(name = "name")
	private String customerName;
	
	@Column(name = "DOB")
	private String customerDateOfBirth;
	
	@Column(name = "gender")
	private String customerGender;
	
	@Column(name = "status")
	private String maritalStatus;
	
	@Column(name = "Lamount")
	private long loanAmount;
	
	@Column(name = "email")
	private String emailId;
	
	@Column(name = "mobile")
	private long mobileNumber;
	
	@Column(name = "pancard")
	private String pancardNumber;
	
	@Column(name = "adhar")
	private String adharNumber;
	
	@Column(name = "adr")
	private String address;
	
	@Column(name = "docs")
	private String documentStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerBankDetails customerBankDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerProfessionalDetails customerProfessionalDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PreviousLoanDetails previousLoanDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerDocuments customerDocuments;
	
	@OneToOne(cascade = CascadeType.ALL)
	private LoanDetails loanDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PropertyDetails propertyDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails guarantorDetails;
	
	
	
	
	
}
