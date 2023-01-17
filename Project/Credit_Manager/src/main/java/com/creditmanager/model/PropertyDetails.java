package com.creditmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDetails {

	private int propertyId;
	private String propertyAddress;
	private String propertyName;
	private String propertyStatus;
	private double propertyAgreementAmount;
	
}
