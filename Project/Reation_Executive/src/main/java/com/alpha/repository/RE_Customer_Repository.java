package com.alpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.model.Customer;

@Repository
public interface RE_Customer_Repository extends JpaRepository<Customer, Integer>{


	
}
