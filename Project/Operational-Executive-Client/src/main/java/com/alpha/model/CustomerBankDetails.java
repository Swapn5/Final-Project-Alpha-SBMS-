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
public class CustomerBankDetails {

	@Id
	private int bankDetailsId;
	private String bankName;
	private long bankAccountNumber;
	private String ifscCode;
	
	
}
