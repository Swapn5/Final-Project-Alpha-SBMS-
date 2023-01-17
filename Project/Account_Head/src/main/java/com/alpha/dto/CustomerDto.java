package com.alpha.dto;

import lombok.Data;

@Data
public class CustomerDto {
	
	private Integer custid;
	private String name;
	private Double loanAmount;
	private Double rateOfInt;
	private Integer tenure;

}
