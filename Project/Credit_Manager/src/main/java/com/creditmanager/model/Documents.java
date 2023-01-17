package com.creditmanager.model;

import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Documents {

	private int cid;
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

