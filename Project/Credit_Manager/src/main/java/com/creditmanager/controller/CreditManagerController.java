package com.creditmanager.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditmanager.dto.CustomerDTO;
import com.creditmanager.feign.CreditFeignRE;
import com.creditmanager.model.Customer;
import com.creditmanager.model.Documents;

@RestController
@RequestMapping ("credit")
@CrossOrigin(origins = "http://localhost:4200")
public class CreditManagerController {
	
	@Autowired
	private CreditFeignRE feign;
	
	@Autowired
	private JavaMailSenderImpl sender;
	
	@GetMapping ("/check")
	public ResponseEntity<String> checkApp(){
		return new ResponseEntity<String>("Credit Manager running", HttpStatus.OK);
	}
	///
	@GetMapping ("/customerList")
	public ResponseEntity<List <Customer>> getAllCustomer(){
		List <Customer> customer=feign.getAllCustomer();
		return new ResponseEntity<List<Customer>>(customer, HttpStatus.OK);
	}
	///
	@GetMapping("/getDocuments/{cid}")
	public ResponseEntity<Documents> getSingleDoc(@PathVariable Integer cid){
		return feign.getSingleDoc(cid);
	}
	
	///
	@GetMapping("/changeStatus/{cid}")
	public void changeLoanStatus(@PathVariable Integer cid) {
		feign.changeLoanStatus(cid);
	}
	
	///
	@GetMapping("/appRejection/{cid}")
	public void rejectLoan(@PathVariable Integer cid) {
		feign.rejectLoan(cid);
	}
	
	
	
	@GetMapping ("/getPreviousLoanDetails/{customerId}")
	public ResponseEntity<CustomerDTO> getPreviousLoanDetails(@PathVariable int customerId){
		Customer cust = feign.getSingleCustomer(customerId);
		CustomerDTO custDTO = new CustomerDTO();
		//custDTO.setPreviousLoanDetails(cust.getPreviousLoanDetails());
		return new ResponseEntity<CustomerDTO>(custDTO, HttpStatus.OK);
	}
	

	

	
	public ResponseEntity<String> applicationRejectionEmail(@PathVariable int customerId) throws MessagingException{
		 MimeMessage message = sender.createMimeMessage();
		 MimeMessageHelper helper = new MimeMessageHelper(message, true);
//		 helper.setTo(cust.getEmailId());  Enter the email ID of Relationship Executive.
		 helper.setFrom("digheajit93@gmail.com");
		 helper.setText("Dear Relationship Executive, Car finance for applicant (customerId) is rejected after thorough review of documents, loan details, previous loan details");
		 helper.setSubject("Car Finance Application Rejection");
		 sender.send(message);
		 return new ResponseEntity<String>("Application Rejection Email successfully sent", HttpStatus.EXPECTATION_FAILED);
		
	}
	
	@GetMapping ("/financeApprovalEmail/{customerId}")
	public ResponseEntity<String> financeApprovalEmail (@PathVariable int customerId) throws MessagingException, IOException {
		 Customer cust = feign.getSingleCustomer (customerId);
		 MimeMessage message = sender.createMimeMessage();
		 MimeMessageHelper helper = new MimeMessageHelper(message, true);
		 helper.setTo("digheajit93@gmail.com");
		 helper.setFrom("digheajit93@gmail.com");
		 
		 helper.setSubject("Car Finance Approval");
			
//		 FileSystemResource file = new FileSystemResource(new File("H:\\Downloads-backup/Brahmatal  22-Feb-2019.pdf"));
//		 helper.addAttachment("Brahmatal  22-Feb-2019.pdf", file);
		 
		 FileSystemResource file = new FileSystemResource(new File("G:\\Wallpapers/bently.jpg"));
		 helper.addInline("Alpha Car Finance Logo", file); 
			
		 sender.send(message);
		 return new ResponseEntity<String>("Car Finance Approval Email successfully sent", HttpStatus.ACCEPTED);  
	}

	/*
	 * @GetMapping ("/getCustomerBankDetails/{customerId}") public
	 * ResponseEntity<CustomerDTO> getCustomerBankDetails(@PathVariable int
	 * customerId){ Customer cust = feign.getSingleCustomer(customerId); CustomerDTO
	 * custDTO = new CustomerDTO();
	 * custDTO.setCustomerBankDetails(cust.getCustomerBankDetails()); return new
	 * ResponseEntity<CustomerDTO>(custDTO, HttpStatus.OK); }
	 * 
	 * @GetMapping ("/getGuarantorDetails/{customerId}") public
	 * ResponseEntity<CustomerDTO> getGuarantorDetails(@PathVariable int
	 * customerId){ Customer cust = feign.getSingleCustomer(customerId); CustomerDTO
	 * custDTO = new CustomerDTO();
	 * custDTO.setGuarantorDetails(cust.getGuarantorDetails()); return new
	 * ResponseEntity<CustomerDTO>(custDTO, HttpStatus.OK); }
	 */
}
