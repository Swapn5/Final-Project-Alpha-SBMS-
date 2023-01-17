package com.creditmanager.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {

	private String name;
	private String surname;
	private String from;
	private String mailTo;
	private String subject;
	private Map <String, Object> model;
	
}
