package com.alpha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarInfo {
	
	@Id
	@SequenceGenerator(name = "cba", sequenceName = "car_sequence",initialValue = 1300 , allocationSize = 1)
	@GeneratedValue(generator = "cba" , strategy = GenerationType.AUTO)
	private Integer carId;
	private Integer regNo;
	private String modelType;
	private String purchaseDate;
	private Integer price;
}
