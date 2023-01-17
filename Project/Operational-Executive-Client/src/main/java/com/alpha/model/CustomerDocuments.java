package com.alpha.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDocuments {

	@Id
	private int customerId;
	@Lob
	private byte[] panCard;
	@Lob
	private byte[] photo;
	@Lob
	private byte[] adharCard;
	@Lob
	private byte[] salarySlips;
	@Lob
	private byte[] bankStatement;
	@Lob
	private byte[] addressProof;
	
	
}
