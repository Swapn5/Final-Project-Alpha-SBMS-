package com.alpha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LoanDetails {

	@Id
	@SequenceGenerator(name = "lmn", sequenceName = "loan_sequence",initialValue = 1500 , allocationSize = 1)
	@GeneratedValue(generator = "lmn" , strategy = GenerationType.AUTO)
	private Integer sanctionId;
	private Long expAmount;
	private Integer expTenure;
	private String bankName;
	private Long accNo;
	private String lstatus;
	private Long sanctionAmount;
	private Double rateOfInt;
	
	
}
