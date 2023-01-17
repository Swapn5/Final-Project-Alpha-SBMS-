package com.alpha.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.alpha.model.Enquiry;

@FeignClient(url = "http://localhost:9011/enquiry", name="enquiry-service")
public interface ReFeignEnquiry {


	@PostMapping("/saveEnquiry")
	public ResponseEntity<String> saveEnquiry(@RequestBody Enquiry enquiry);
	

	@DeleteMapping("/deleteEnquiry/{custId}")
	public ResponseEntity<String> deleteEnquiry(@PathVariable Integer custId);
}
