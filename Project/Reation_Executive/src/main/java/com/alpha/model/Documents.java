package com.alpha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Documents {

	@Id
	@SequenceGenerator(name = "abc", sequenceName = "doc_sequence",initialValue = 500000 , allocationSize = 1)
	@GeneratedValue(generator = "abc" , strategy = GenerationType.AUTO)
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
