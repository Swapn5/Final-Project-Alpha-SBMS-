package com.alpha.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alpha.dto.Converter;
import com.alpha.dto.EmployeeDto;
import com.alpha.model.EmpProfile;
import com.alpha.model.Employee;
import com.alpha.service.AdminService;


@RestController
@RequestMapping("admin")
@CrossOrigin(origins = "http://localhost:4200/")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@Autowired
	private Converter con;
	
	@GetMapping("/")
	public ResponseEntity<String> checkAPI(){
		return new ResponseEntity<String>("Admin-Service Working", HttpStatus.OK);
	}
	
	@PostMapping("/employee")
	public ResponseEntity<String> addEmployees(@RequestBody Employee emp){
		service.addEmployee(emp);
		return new ResponseEntity<>("Employee added successfully",HttpStatus.CREATED);
	}
	
	@PostMapping("/empProfile")
	public ResponseEntity<String> addEmpProfile(@RequestParam("profile") MultipartFile f1) throws IOException{
		EmpProfile pr = new EmpProfile();
		pr.setProfile(f1.getBytes());
		service.addEmpProfile(pr);
		return new ResponseEntity<String>("Employee Profile Added",HttpStatus.CREATED);
	}
	
	@GetMapping("/employeeList")
	public ResponseEntity<List<EmployeeDto>> getEmployeeList(){
		
		List<Employee> eList = service.getEmployeeList();
		List<EmployeeDto> list = con.entityToDto(eList);
		return new ResponseEntity<List<EmployeeDto>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/employee/{eid}/{password}")
	public ResponseEntity<EmployeeDto> login(@PathVariable Integer eid,@PathVariable char[] password){
		
		Employee emp=service.login(eid,password);
		EmployeeDto dto = con.entityToDto(emp);
		return new ResponseEntity<EmployeeDto>(dto,HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{eid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer eid){
		service.deleteEmployee(eid);
		return new ResponseEntity<String>("Employee Deleted Successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/empProfile/{eid}")
	public ResponseEntity<String> deleteEmpPhoto(@PathVariable Integer eid){
		service.deleteEmpPhoto(eid);
		return new ResponseEntity<String>("Deleted Employee Profile Photo",HttpStatus.OK);
	}
	
	
	
}
