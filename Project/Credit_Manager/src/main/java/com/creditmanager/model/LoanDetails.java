package com.creditmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDetails {

	private Integer sanctionId;
	private Long expAmount;
	private Integer expTenure;
	private String bankName;
	private Long accNo;
	private String lstatus;
	private Long sanctionAmount;
	private Double rateOfInt;
}
