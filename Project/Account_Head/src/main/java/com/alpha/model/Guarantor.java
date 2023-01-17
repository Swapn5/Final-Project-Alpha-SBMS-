package com.alpha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guarantor {

	private Integer gid;
	private String gname;
	private String relation;
	private Long mobile;
	private String desig;
}
