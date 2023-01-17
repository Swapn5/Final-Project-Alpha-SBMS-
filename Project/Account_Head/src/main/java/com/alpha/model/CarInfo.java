package com.alpha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarInfo {
	
	private Integer carId;
	private Integer regNo;
	private String modelType;
	private String purchaseDate;
	private Integer price;
}
