package com.alpha.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.alpha.model.Employee;

import lombok.Data;

@Data
@Component
public class Converter {
	
	public EmployeeDto entityToDto(Employee emp) {
		
		EmployeeDto empdto = new EmployeeDto();
		empdto.setEid(emp.getEid());
		empdto.setFirstName(emp.getFirstName());
		empdto.setLastName(emp.getLastName());
		empdto.setEmail(emp.getEmail());
		empdto.setRole(emp.getRole());
		return empdto;
	}
	
	public List<EmployeeDto> entityToDto(List<Employee> elist){
		
		return elist.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

}
