package com.app.employeedetails.dao;

import java.util.List;

import com.app.employeedetails.model.Employee;

public interface EmployeeIDao {

	//create
	public String addEmployee(Employee emp);
	
	//update
	public String updateEmployee(Employee emp);
	
	//delete
	public String deleteEmployee(String eid);
	
	//read
    public List<Employee> viewEmployeeById(String eid);
	
	//read all
	public List<Employee> viewEmployee();
}
