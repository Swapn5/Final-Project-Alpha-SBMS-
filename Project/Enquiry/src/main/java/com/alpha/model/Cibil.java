package com.alpha.model;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cibil {

	
	@Id
	private int cibilId;
	private int cibilScore;
	private String cibilRemark;

}
