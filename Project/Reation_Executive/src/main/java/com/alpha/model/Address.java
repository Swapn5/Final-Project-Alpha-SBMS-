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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
	
	@Id
	@SequenceGenerator(name = "abc", sequenceName = "adress_sequence",initialValue = 1000 , allocationSize = 1)
	@GeneratedValue(generator = "abc" , strategy = GenerationType.AUTO)
	private Integer aid;
	private String area;
	private String city;
	private String district;
	private String state;
	private Integer pincode;
}
