package com.creditmanager.feign;

import java.util.List; 

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.creditmanager.model.Customer;
import com.creditmanager.model.Documents;

@FeignClient (url = "http://localhost:9021/REAPI", name="re-service")
public interface CreditFeignRE {

	@GetMapping ("/customerList")
	List<Customer> getAllCustomer();

	@GetMapping ("/getSingleCustomer/{customerId}")
	Customer getSingleCustomer(@PathVariable int customerId);
	
	@GetMapping("/getDocuments/{cid}")
	public ResponseEntity<Documents> getSingleDoc(@PathVariable Integer cid);
	
	@GetMapping("/changeStatus/{cid}")
	public void changeLoanStatus(@PathVariable Integer cid);
	
	@GetMapping("/appRejection/{cid}")
	public void rejectLoan(@PathVariable Integer cid);
	
	
	@GetMapping("/getSingleCustomer/{cid}")
	public Customer getSingleCustomer(@PathVariable Integer cid);
}
