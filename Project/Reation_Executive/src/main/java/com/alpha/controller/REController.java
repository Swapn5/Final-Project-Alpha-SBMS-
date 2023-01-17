package com.alpha.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alpha.feign.ReFeignEnquiry;
import com.alpha.model.Customer;
import com.alpha.model.Documents;
import com.alpha.model.Enquiry;
import com.alpha.service.REService;

@RestController
@RequestMapping("REAPI")
@CrossOrigin(origins = "http://localhost:4200")
public class REController {
	
	@Autowired
	private REService service;
	
	@Autowired
	private ReFeignEnquiry feign;

	@GetMapping("/")
	public ResponseEntity<String> check() {	
		return new ResponseEntity<String>("RE Working",HttpStatus.OK);
	}
	

	@PostMapping("/saveEnquiry")
	public ResponseEntity<String> saveEnquiry(@RequestBody Enquiry enquiry){
		return feign.saveEnquiry(enquiry);
	}
	

	@DeleteMapping("/deleteEnquiry/{custId}")
	public ResponseEntity<String> deleteEnquiry(@PathVariable Integer custId){
		return feign.deleteEnquiry(custId);
	}
	
	@PostMapping("/saveCustomerData")
	public ResponseEntity<String> saveCustomerData(@RequestBody Customer customer) {
		customer.getLoan().setLstatus("Pending");
		service.saveCustomerData(customer);
		return new ResponseEntity<String>(new String("Customer Data Saved"),HttpStatus.CREATED);
	}
	
	@PostMapping("/uploadDocuments")
	public ResponseEntity<String> uploadDocuments(
								@RequestPart MultipartFile f1,
								@RequestPart MultipartFile f2,
								@RequestPart MultipartFile f3,
								@RequestPart MultipartFile f4,
								@RequestPart MultipartFile f5,
								@RequestPart MultipartFile f6
								) 
	throws IOException{
		
		Documents cd = new Documents();
		
		cd.setPhoto(f1.getBytes());
		cd.setAdharCard(f2.getBytes());
		cd.setPanCard(f3.getBytes());
		cd.setSalarySlips(f4.getBytes());
		cd.setBankStatement(f5.getBytes());
		cd.setAddressProof(f6.getBytes());
		service.uploadDocuments(cd);
		return new ResponseEntity<String>("Documents Uploaded", HttpStatus.OK);
	}
	
	@GetMapping("/customerList")
	public ResponseEntity<List<Customer>> getAllCustomer() {
	 	List<Customer> list = service.getAllCustomer();
	 	return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getDocuments/{cid}")
	public ResponseEntity<Documents> getSingleDoc(@PathVariable Integer cid){
		Documents doc=service.getSingleDoc(cid); 
		return new ResponseEntity<Documents>(doc,HttpStatus.OK);
	}
	
	@GetMapping("/getSingleCustomer/{cid}")
	public Customer getSingleCustomer(@PathVariable Integer cid){
		Customer customer = service.getSingleCustomer(cid);
		return customer;
	}
	
	@GetMapping("/changeStatus/{cid}")
	public void changeLoanStatus(@PathVariable Integer cid) {
		Customer customer = service.getSingleCustomer(cid);
		if(customer.getLoan().getLstatus().equals("Pending"))
			customer.getLoan().setLstatus("Verified");
		else if(customer.getLoan().getLstatus().equals("Verified"))
			customer.getLoan().setLstatus("Sanctioned");
		service.saveCustomerData(customer);
	}
	
	@GetMapping("/appRejection/{cid}")
	public void rejectLoan(@PathVariable Integer cid) {
		Customer customer = service.getSingleCustomer(cid);
		if(customer.getLoan().getLstatus().equals("Pending")) {
		customer.getLoan().setLstatus("Failed");
		service.saveCustomerData(customer);
		}
	}
	
	@GetMapping("/verifiedList")
	public ResponseEntity<List<Customer>> getVerifiedList(){
		List<Customer> list=service.getVerifiedList();
		return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
	}
	
	
	@PutMapping("/sanction")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer){
		customer.getLoan().setLstatus("Sanctioned");
		service.saveCustomerData(customer);
		return new ResponseEntity<String>("Loan Details Updated",HttpStatus.OK);
	}
}
