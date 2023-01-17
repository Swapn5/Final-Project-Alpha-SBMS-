package com.alpha.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.model.Employee;

public interface AdminRepository extends JpaRepository<Employee, Integer>{

}
