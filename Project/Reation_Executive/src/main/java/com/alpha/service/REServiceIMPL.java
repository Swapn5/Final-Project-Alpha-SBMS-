package com.alpha.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.model.Customer;
import com.alpha.model.Documents;
import com.alpha.repository.RE_Customer_Repository;
import com.alpha.repository.RE_Documents_Repository;

@Service
public class REServiceIMPL implements REService {

	@Autowired
	private RE_Customer_Repository cusrepo;

	@Autowired
	private RE_Documents_Repository docrepo;

	@Override
	public void saveCustomerData(Customer customer) {
		cusrepo.save(customer);
	}

	@Override
	public void uploadDocuments(Documents cd) {
		docrepo.save(cd);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return cusrepo.findAll();
	}

	@Override
	public Documents getSingleDoc(Integer cid) {
		return docrepo.findById(cid).get();
	}

	@Override
	public Customer getSingleCustomer(Integer cid) {
		return cusrepo.findById(cid).get();
	}

	@Override
	public List<Customer> getVerifiedList() {
		List<Customer> findAll = cusrepo.findAll();
		List<Customer> vlist = new ArrayList<Customer>();
		for(Customer c : findAll) {
			System.out.println(c.toString());
			if(c.getLoan().getLstatus().equals("Verified") || c.getLoan().getLstatus().equals("Sanctioned") )
				vlist.add(c);
		}
		 return vlist;
	}
}
