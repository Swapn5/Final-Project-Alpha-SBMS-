package com.alpha.rest;


import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.model.Enquiry;
import com.alpha.service.EnquiryService;

@RestController
@RequestMapping("/enquiry")
@CrossOrigin(origins = "http://localhost:4200")
public class EnquiryController {
	
	@Autowired
	private EnquiryService service;
	
	@GetMapping("/")
	public String check() {
		return "Enquiry Module Working";
	}
	
	@PostMapping("/saveEnquiry")
	public ResponseEntity<String> saveEnquiry(@RequestBody Enquiry enquiry) {
		enquiry.setEnquiryStatus("pending");
		service.saveEnquiry(enquiry);
		return new ResponseEntity<String>("Enquiry Data Saved", HttpStatus.CREATED);
	}
	
	@GetMapping("/singleEnquiry/{custId}")
	public Enquiry getSingleEnquiry(@PathVariable Integer custId){
		Enquiry enquiry = service.getSingleEnquiry(custId);
		return enquiry;
	}
	
	@GetMapping("/enquiryList")
	public ResponseEntity<List<Enquiry>> getEnquiryList(){
		List<Enquiry> list = service.getEnquiryList();
		return new ResponseEntity<List<Enquiry>> (list,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEnquiry/{custId}")
	public ResponseEntity<String> deleteEnquiry(@PathVariable Integer custId){
		service.deleteEnquiry(custId);
		return new ResponseEntity<String>("Enquiry Deleted",HttpStatus.OK);
	}
	
	@GetMapping("/cibilScore/{custId}")
	public ResponseEntity<Integer> getCibilScore(@PathVariable Integer custId) {
	
		Enquiry en = service.getSingleEnquiry(custId);
		int min = 600;  
		int max = 900;  
		Random r=new Random();
		int i = r.nextInt(max-min)+min;
		en.setCibil(i);
		System.out.println(i);
		
		if(en.getCibil()>700)
			en.setEnquiryStatus("eligible");
		else
			en.setEnquiryStatus("low cibil");
		
		service.saveEnquiry(en);	
		return new ResponseEntity<Integer>(en.getCibil(),HttpStatus.OK);
	}
	
	@GetMapping("/statusChange/{custId}")
	public void ChangeStatus(@PathVariable Integer custId) {
		
		Enquiry en = service.getSingleEnquiry(custId);
		
		if(en.getEnquiryStatus().equals("low cibil"))
			en.setEnquiryStatus("rejected");
		else if(en.getEnquiryStatus().equals("eligible"))
			en.setEnquiryStatus("verified");
		else if(en.getEnquiryStatus().equals("verified"))
			en.setEnquiryStatus("registerd");
		
		System.out.println(en);
		service.saveEnquiry(en);
	}
}
