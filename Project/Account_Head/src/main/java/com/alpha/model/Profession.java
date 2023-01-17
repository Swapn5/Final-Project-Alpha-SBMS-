package com.alpha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profession {

	private Integer pid;
	private String ptype;
	private String companyName;
	private String desig;
	private Long mincome;
}
