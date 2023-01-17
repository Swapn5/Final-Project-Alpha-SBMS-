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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmpProfile {
	
	@Id
	@SequenceGenerator(name = "abc",sequenceName = "profile_sequence", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "abc", strategy = GenerationType.AUTO)
	private Integer eid;
	@Lob
	private byte[] profile;
}
