package com.alpha.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.model.EmpProfile;
import com.alpha.model.Employee;
import com.alpha.repo.AdminRepository;
import com.alpha.repo.EmpProfileRepository;

@Service
public class AdminServiceIMPL implements AdminService{

	@Autowired
	private AdminRepository rep;
	
	@Autowired
	private EmpProfileRepository prep;
	
	@Override
	public void addEmployee(Employee emp) {
		rep.save(emp);
	}

	@Override
	public List<Employee> getEmployeeList() {
		List<Employee> elist = rep.findAll();
		return elist;
	}

	@Override
	public Employee login(Integer eid, char[] password) {
		if(rep.existsById(eid)) {
			Employee emp = rep.findById(eid).get();
			if(Arrays.equals(password, emp.getPassword()))
				return emp;
		}	
		return null;
	}

	@Override
	public void deleteEmployee(Integer eid) {
		rep.deleteById(eid);
	}

	@Override
	public void addEmpProfile(EmpProfile pr) {
		prep.save(pr);
	}

	@Override
	public void deleteEmpPhoto(Integer eid) {
		prep.deleteById(eid);
	}
	
	
}
