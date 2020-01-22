package com.app.employeedetails.service;

import java.sql.SQLException;
import java.util.List;

import com.app.employeedetails.model.EmpErrorMsg;
import com.app.employeedetails.model.Employee;

public interface EmployeeIService {
	
	//create
	public List<EmpErrorMsg> addEmployee(Employee emp) throws SQLException;
	
	//update
	public List<EmpErrorMsg> updateEmployee(Employee emp);
	
	//delete
	public List<EmpErrorMsg> deleteEmployee(String eid);
	
	//read
	public List<Employee> viewEmployeeById(String eid);
	
	//read all
	public List<Employee> viewEmployee();

}
