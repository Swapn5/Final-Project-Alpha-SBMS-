package com.alpha.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.Feign.OeFeignEnquiry;
import com.alpha.model.Enquiry;

@RestController
@RequestMapping("/OEAPI")
@CrossOrigin(origins = "http://localhost:4200")
public class OEController {
	
	@Autowired
	private OeFeignEnquiry feignEn;
	
	
	@GetMapping("/enquiryList")
	public ResponseEntity<List<Enquiry>> getEnquiryList(){
		return feignEn.getEnquiryList();
	}
	
	@GetMapping("/cibilScore/{custId}")
	public ResponseEntity<Integer> getCibilScore(@PathVariable Integer custId){
		return feignEn.getCibilScore(custId);
	}
	

	/*
	 * // @PostMapping("/FeignsaveEnquiry") // public ResponseEntity<String>
	 * saveEnquiry(@RequestBody Enquiry enquiry) // { // f.saveEnquiry(enquiry); //
	 * // return new ResponseEntity<String>("Enquiry Data Saved",
	 * HttpStatus.CREATED); // }
	 */	
	
	/*
	 * @PostMapping("/feignsaveCustomerData") public ResponseEntity<String>
	 * saveCustomerData(@RequestBody Customer customer) {
	 * f.saveCustomerData(customer);
	 * 
	 * return new ResponseEntity<String>("Customer Data Saved",HttpStatus.CREATED);
	 * }
	 */

	/*
	 * // @GetMapping("/feigngetAllEnquiry") // public
	 * ResponseEntity<List<Enquiry>>getAllEnquiry() // { // List<Enquiry>
	 * l=f.getAllEnquiry(); // // return new
	 * ResponseEntity<List<Enquiry>>(l,HttpStatus.OK); // }
	 */	
	
	/*
	 * @GetMapping("/feigngetAllCustomer") public
	 * ResponseEntity<List<Customer>>getAllCustomer() { List<Customer> c=
	 * f.getAllCustomer(); return new
	 * ResponseEntity<List<Customer>>(c,HttpStatus.OK); }
	 */
	
//	@GetMapping("/feigngetEnquiryByid/{id}")
//	public ResponseEntity<Enquiry>getEnquiryByid(@PathVariable int id)
//	{
//		Enquiry e= f.getEnquiryByid(id);
//		return new ResponseEntity<Enquiry>(e,HttpStatus.OK);
//	}


}