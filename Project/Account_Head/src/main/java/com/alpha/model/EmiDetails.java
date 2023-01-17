package com.alpha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmiDetails {

	private Integer emiId;
	private String emiStatus;
	private Long emiAmount;
	private Integer emiTenure;	
	private String emiPaid;
	private Integer defaultorCount;
	
	


}
