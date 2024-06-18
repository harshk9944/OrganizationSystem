package com.tka.OrganizationSystem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;
import com.tka.OrganizationSystem.service.MainService;

@RestController
@RequestMapping("api")
public class MainController {

	@Autowired
	MainService service;
	
	@PostMapping("postcountry")
    public String postCountry(@RequestBody Country c) {
    
		String msg=service.addCountryData(c);
		return msg;
    }
	
	@PutMapping("putcountry/{id}")
	public String putCountry(@PathVariable int id,@RequestBody Country c) {
		
		String msg= service.updateCountry(id,c);
		return msg;
	}
	
	@DeleteMapping("deletecountry/{id}")
	public String deleteCountry(@PathVariable int id) {
		String msg= service.deleteCountryData(id);
		return msg;
	}
	
	@GetMapping("getallrecord")
	public List<Country> getAllRecord() {
		List<Country> list= service.getAllRec();
		return list;
	}
	
	@PostMapping("addemployee")
	public String addEmployee(@RequestBody Employee emp) {
		String msg= service.addEmployee(emp);
		return msg;
		
	}
	@PutMapping("updateemp")
	public String updateEmployee(@RequestBody Employee emp) {
	   String msg=service.updateEmployee(emp); 
		return msg;
	}
	
	@DeleteMapping("deleteemployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		String msg=service.deleteEmployee(id);
		return msg;
	}
	
	@GetMapping("gettotalrecord")
	public List<Employee> getTotalRecord(){
	  List<Employee> list= service.getTotalRecord();
	  return list;
	}
	
	@GetMapping("getparticular/{id}")
	public Employee getParticular(@PathVariable int id) {
		Employee emp=service.getParticular(id);
		return emp;
	}
	
	@GetMapping("getparticularbysts/{status}")
	public List<Employee> getParticularbystatus(@PathVariable String status) {
		List<Employee> list=service.getParticularbystatus(status);
		return list;
	}
	
	@PostMapping("logindata")
	public HashMap logInData(@RequestBody Employee emp) {
	  HashMap map=service.logInData(emp);
		return map;
	}
	
	@GetMapping("getparticularbysalary/{salary}")
	public List<Employee> getparticularBySalary(@PathVariable double salary){
		List<Employee> list=service.getparticularBySalary(salary);
		
		return list;
		
	}
	
	@GetMapping("getbetweenbysalary/{salary}/{salary1}")
	public List<Employee> getBetweenBySalary(@PathVariable double salary,@PathVariable double salary1){
		List<Employee> list=service.getBetweenBySalary(salary,salary1);
		
		return list;
		
	}
}
