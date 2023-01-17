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
public class Profession {

	@Id
	@SequenceGenerator(name = "pqr", sequenceName = "customerProff_sequence",initialValue = 1200 , allocationSize = 1)
	@GeneratedValue(generator = "pqr" , strategy = GenerationType.AUTO)
	private Integer pid;
	private String ptype;
	private String companyName;
	private String desig;
	private Long mincome;
}
