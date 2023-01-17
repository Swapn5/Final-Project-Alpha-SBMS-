package com.alpha.Feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.alpha.model.Customer;

@FeignClient(url = "http://localhost:9021/REAPI", name = "re-service")
public interface FeignRE
{

//	@PostMapping("/REAPI/saveEnquiry")
//	public void saveEnquiry(Enquiry enquiry);
//
//	
	
	@PostMapping("/REAPI/saveCustomerData")
	public void saveCustomerData(Customer customer);

	
//	@GetMapping("/REAPI/getEnquiry") 
//	public List<Enquiry> getAllEnquiry();


	@GetMapping("/REAPI/getAllCustomer")
	public List<Customer> getAllCustomer();


//	@PostMapping("/enquiry/saveEnquiry")
//	public void saveEnquiry(Enquiry enquiry);


//	@GetMapping("/REAPI/getEnquiryByid/{id}")
//	public Enquiry getEnquiryByid(@ PathVariable int id);
//	
	
	
	
	

}
