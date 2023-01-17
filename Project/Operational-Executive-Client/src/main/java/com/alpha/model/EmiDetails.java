package com.alpha.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmiDetails 
{
	
	@Id
	private int emiDetailsId;
	private String emiStatus;
	private long emiAmount;
	private int emiTenure;
	private String emiPaid;
	private long deafultorCount;
	
	@OneToOne(cascade = CascadeType.ALL)
	private SanctionedLoan sanctionedLoan;


}
