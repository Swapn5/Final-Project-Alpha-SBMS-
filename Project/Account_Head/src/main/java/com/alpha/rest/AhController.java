package com.alpha.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.feign.ReFeign;
import com.alpha.model.Customer;

@RestController
@RequestMapping("ahead")
@CrossOrigin(origins = "http://localhost:4200/")
public class AhController {
	
	@Autowired
	private ReFeign feign;
	
	@GetMapping("/verifiedList")
	public ResponseEntity<List<Customer>> getVerifiedList(){
		return feign.getVerifiedList();
	}
	
	@PutMapping("/sanction")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer){
		return feign.updateCustomer(customer);
	}
	
}
