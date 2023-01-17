package com.alpha.service;

import java.util.List; 

import com.alpha.model.Customer;
import com.alpha.model.Documents;


public interface REService {

	void saveCustomerData(Customer customer);

	void uploadDocuments(Documents cd);

	List<Customer> getAllCustomer();

	Documents getSingleDoc(Integer cid);

	Customer getSingleCustomer(Integer cid);

	List<Customer> getVerifiedList();
	
}
