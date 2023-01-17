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
public class Guarantor {

	@Id
	@SequenceGenerator(name = "ghi", sequenceName = "guarantor_sequence",initialValue = 1400 , allocationSize = 1)
	@GeneratedValue(generator = "ghi" , strategy = GenerationType.AUTO)
	private Integer gid;
	private String gname;
	private String relation;
	private Long mobile;
	private String desig;
}
