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
public class PreviousLoanDetails {

	@Id
	private int previousLoanDetailsId;
	private long loanAmount;
	private int loanTenure;
	private long paidAmount;
	private long remainingAmount;
	private int defaulterCount;
	private String bankname;
}
