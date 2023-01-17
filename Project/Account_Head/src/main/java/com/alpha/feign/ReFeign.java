package com.alpha.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.alpha.model.Customer;

@FeignClient(url = "http://localhost:9021/REAPI", name="re-service")
public interface ReFeign {

	@GetMapping("/verifiedList")
	public ResponseEntity<List<Customer>> getVerifiedList();
	
	@PutMapping("/sanction")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer);
}
