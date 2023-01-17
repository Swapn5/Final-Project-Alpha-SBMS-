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
public class GuarantorDetails {

	@Id
	private int guarantorId;
	private String guarantorName;
	private String relation;
	private long mobileNumber;
	private String designation;
}
