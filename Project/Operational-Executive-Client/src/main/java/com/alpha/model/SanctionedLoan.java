package com.alpha.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SanctionedLoan 
{
	@Id
	private int sanctionedLoanId;
	private long sanctionedLoanAmount;
	private int sanctionedTenure;
	private float emi;
	private long disbursedAmount;
	private String customerName;
	private int customerId;
	private int defaultorCount;



}
