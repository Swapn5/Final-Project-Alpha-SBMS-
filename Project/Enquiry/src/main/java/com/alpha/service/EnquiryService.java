package com.alpha.service;

import java.util.List;

import com.alpha.model.Enquiry;

public interface EnquiryService {

	void saveEnquiry(Enquiry enquiry);

	List<Enquiry> getEnquiryList();

	Enquiry getSingleEnquiry(Integer id);

	void deleteEnquiry(Integer custId);	
}
