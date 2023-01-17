package com.alpha.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Email 
{
	@Id
	private String toEmail;
	@Value("${Email.fromEmail}")
	private String fromEmail;
	private String subject;
	private String message;

	

}
