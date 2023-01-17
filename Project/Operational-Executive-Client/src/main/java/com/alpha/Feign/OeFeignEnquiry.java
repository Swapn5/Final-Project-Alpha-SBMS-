package com.alpha.Feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alpha.model.Enquiry;

@FeignClient(url = "http://localhost:9011/enquiry", name="enquiry-service")
public interface OeFeignEnquiry {

	@GetMapping("/enquiryList")
	public ResponseEntity<List<Enquiry>> getEnquiryList();
	
	@GetMapping("/cibilScore/{custId}")
	public ResponseEntity<Integer> getCibilScore(@PathVariable Integer custId);

}
