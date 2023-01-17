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
public class PropertyDetails {

	@Id
	private int propertyId;
	private String propertyAddress;
	private String propertyName;
	private String propertyStatus;
	private double propertyAgreementAmount;
	
}
