package com.tka.OrganizationSystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.OrganizationSystem.dao.MainDao;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Service
public class MainService {

	@Autowired
	MainDao dao;
	public String addCountryData(Country c) {
		// TODO Auto-generated method stub
		
		String msg= dao.addCountryData(c);
		
		if(Objects.isNull(msg)) {
			msg="The data is not added in country";
		}
		return msg;
	}
	public String updateCountry(int id, Country c) {
		// TODO Auto-generated method stub
		String msg= dao.updateCountry(id,c);
		if(Objects.isNull(msg)) {
			msg="Data is not updated";
		}
		
		return msg;
	}
	public String deleteCountryData(int id) {
		// TODO Auto-generated method stub
		String msg= dao.deleteCountryData(id);
		
		if(Objects.isNull(msg)) {
			msg="Data is not deleted";
		}
		return msg;
	}
	public List<Country> getAllRec() {
		// TODO Auto-generated method stub
		List<Country> list= dao.getAllRec();
		return list;
	}
	public String addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		String msg= dao.addEmployee(emp);
		if(Objects.isNull(msg)) {
			msg="Data is not added in employee";
		}
		
		return msg;
	}
	public String updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		String msg=dao.updateEmployee(emp);
		if(Objects.isNull(msg)) {
			msg="data is not updated";
		}
		return msg;
	}
	public String deleteEmployee(int id) {
		// TODO Auto-generated method stub
		String msg=dao.deleteEmployee(id);
		if(Objects.isNull(msg)) {
			msg="not deleted";
		}
		return msg;
	}
	public List<Employee> getTotalRecord() {
		// TODO Auto-generated method stub
		List<Employee> list= dao.getTotalRecord();
		if(Objects.isNull(list)) {
			list=null;
		}
		return list;
	}
	public Employee getParticular(int id) {
		// TODO Auto-generated method stub
		Employee emp=dao.getParticular(id);
		if(Objects.isNull(emp)) {
			emp=null;
		}
		return emp;
	}
	public List<Employee> getParticularbystatus(String status) {
		// TODO Auto-generated method stub
		List<Employee> list= dao.getParticularbystatus(status);
		if(Objects.isNull(list)) {
			list=null;
		}
		return list;
	}
	public HashMap logInData(Employee emp) {
		// TODO Auto-generated method stub
		Employee employee=dao.logInData(emp);
		HashMap map=new HashMap();
		//map.put(employee, map);
		if(Objects.isNull(employee)) {
	     map.put("msg","Invalid user");
		 map.put("user",employee);
		}else {
			map.put("msg", "valid user");
			map.put("user", employee);
		}
		return map;
	}
	public List<Employee> getparticularBySalary(double salary) {
		// TODO Auto-generated method stub
		List<Employee> list =dao.getparticularBySalary(salary);
		
		if(Objects.isNull(list)) {
			list=null;
		}
		return list;
	}
	public List<Employee> getBetweenBySalary(double salary, double salary1) {
		// TODO Auto-generated method stub
        List<Employee> list =dao.getBetweenBySalary(salary,salary1);
		
		if(Objects.isNull(list)) {
			list=null;
		}
		
		return list;
	}


}
