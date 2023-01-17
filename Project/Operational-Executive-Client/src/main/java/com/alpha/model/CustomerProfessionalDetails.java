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
public class CustomerProfessionalDetails {

	@Id
	private int professionalDetailsId;
	private String companyName;
	private String designation;
	private long monthlyIncome;
}
