package com.app.employeedetails.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
//import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.app.employeedetails.dao.EmployeeImplDao;
import com.app.employeedetails.model.EmpErrorMsg;
import com.app.employeedetails.model.Employee;

@Service
public class EmployeeImplService implements EmployeeIService 
{

	@Autowired
	private EmployeeImplDao empDao;
	
	static List<EmpErrorMsg> listmsg=new ArrayList<EmpErrorMsg>();
	
	
	
	public List<EmpErrorMsg> addEmployee(Employee emp) throws SQLException 
	{
		try
		{
			
			String msg=empDao.addEmployee(emp);		
			if(msg.equals("success"))
			{
				
			}
			if(msg.equals("failure"))
			{	
				EmpErrorMsg errormsg2=new EmpErrorMsg();
				errormsg2.setMsgcode("EINSDB");
				errormsg2.setMsg("Employee Data Couldn't be Saved.");	
				listmsg.add(errormsg2);
			}
			if(msg.equals("idalreadyfound"))
			{
				EmpErrorMsg errormsg1=new EmpErrorMsg();
				errormsg1.setMsgcode("EINSDB");
				errormsg1.setMsg("Employee Record already Exists.");	
				listmsg.add(errormsg1);
			}
		}
		//catch(DuplicateKeyException e)
		catch (DataAccessException e)
		{
			EmpErrorMsg errormsg4=new EmpErrorMsg();
			errormsg4.setMsgcode("EINSDB");
			errormsg4.setMsg("Problem Occurred in Inserting the Employee Data.");	
			listmsg.add(errormsg4);
		}
		
		return listmsg;
	}

	public List<EmpErrorMsg> updateEmployee(Employee emp) 
	{
		// TODO Auto-generated method stub
		try 
		{
		String msg=empDao.updateEmployee(emp);
			if(msg.equals("success"))
			{
				
			}
			if(msg.equals("failure"))
			{
			    EmpErrorMsg errormsg7=new EmpErrorMsg();
				errormsg7.setMsgcode("EUPDDB");
				errormsg7.setMsg("Employee Data Updation Failure.");	
				listmsg.add(errormsg7);
			}	
			if(msg.equals("idnotfound"))
			{
				EmpErrorMsg errormsg1=new EmpErrorMsg();
				errormsg1.setMsgcode("EINSDB");
				errormsg1.setMsg("Employee Record already Exists.");	
				listmsg.add(errormsg1);
			}
			
		}
		catch (EmptyResultDataAccessException e) 
		{
			EmpErrorMsg errormsg9=new EmpErrorMsg();
			errormsg9.setMsgcode("EUPDDB");
			errormsg9.setMsg("Employee Id is invalid, No data found.");	
			listmsg.add(errormsg9);
		}
		catch (DataAccessException e)
		{
			EmpErrorMsg errormsg10=new EmpErrorMsg();
			errormsg10.setMsgcode("EUPDDB");
			errormsg10.setMsg("Problem Occurred in updating the Employee Data.");	
			listmsg.add(errormsg10);
		}
		return listmsg;
	}
	
	/**
	 * @param eid
	 * @return
	 */
	@Override
	public List<EmpErrorMsg> deleteEmployee(String eid) {
		// TODO Auto-generated method stub
		String msg=empDao.deleteEmployee(eid);
		if(msg.equals("success"))
		{
			
		}
		else if(msg.equals("failure"))
		{
			EmpErrorMsg errormsg12=new EmpErrorMsg();
			errormsg12.setMsgcode("EDELDB");
			errormsg12.setMsg("No Employee Data Exists with the Employee Id.");	
			listmsg.add(errormsg12);
		}		
		return listmsg;
	}


	@Override
	public List<Employee> viewEmployee() 
	{
		// TODO Auto-generated method stub
		
		return empDao.viewEmployee();
	}

	@Override
	public List<Employee> viewEmployeeById(String eid) 
	{
		// TODO Auto-generated method stub
		return empDao.viewEmployeeById(eid);
		
	}

	
}
