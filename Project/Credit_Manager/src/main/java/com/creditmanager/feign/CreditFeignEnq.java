package com.creditmanager.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.creditmanager.model.Enquiry;


@FeignClient(url = "http://localhost:9011/enquiry", name = "enquiry-service")
public interface CreditFeignEnq {

	@GetMapping("/singleEnquiry/{custId}")
	public Enquiry getSingleEnquiry(@PathVariable Integer custId);
}
