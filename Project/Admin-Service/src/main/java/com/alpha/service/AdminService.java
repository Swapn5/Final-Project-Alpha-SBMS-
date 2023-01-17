package com.alpha.service;

import java.util.List;

import com.alpha.model.EmpProfile;
import com.alpha.model.Employee;

public interface AdminService {

	void addEmployee(Employee emp);
	List<Employee> getEmployeeList();
	Employee login(Integer eid, char[] password);
	void deleteEmployee(Integer eid);
	void addEmpProfile(EmpProfile pr);
	void deleteEmpPhoto(Integer eid);
}
