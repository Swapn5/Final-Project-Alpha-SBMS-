package com.alpha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.model.Enquiry;
import com.alpha.repository.EnquiryRepository;


@Service
public class EnquiryServiceIMPL implements EnquiryService{

	@Autowired
	private EnquiryRepository rep;
	
	@Override
	public void saveEnquiry(Enquiry enquiry) {
		rep.save(enquiry);
	}

	@Override
	public List<Enquiry> getEnquiryList() {
		List<Enquiry> list = rep.findAll();
		return list;
	}

	@Override
	public Enquiry getSingleEnquiry(Integer id) {
		if(rep.existsById(id))
			return rep.findById(id).get();
		else
			return null;
	}

	@Override
	public void deleteEnquiry(Integer custId) {
		rep.deleteById(custId);
	}
}
