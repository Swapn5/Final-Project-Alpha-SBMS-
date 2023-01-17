package com.alpha.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LoanDetails {

	@Id
	private int loanDetailsId;
	private long expectedLoanAmount;
	private int expectedLoanTenure;
	private long expectedEmiAmount;
	private String loanStatus;
	private String loanDisbursedStatus;
	
}
