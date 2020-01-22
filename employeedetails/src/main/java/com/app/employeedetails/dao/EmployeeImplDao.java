package com.app.employeedetails.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.app.employeedetails.model.Employee;

//perform all transactions
@Transactional
//for storing and retrieving data
@Repository
public class EmployeeImplDao implements EmployeeIDao 
{

	 @Autowired
	 private JdbcTemplate template;
	
	 
	
	@Override
	public String addEmployee(Employee emp) 
	{
		// TODO Auto-generated method stub
		int count = template.queryForObject("select count(eid) from employee where eid = ?", Integer.class, emp.getEid());
		
		System.out.println("--------------insert select count-------------"+count);
		//id found - cannot insert
		if(count==1)
		{
			return "idalreadyfound";
		}
		//id not found - insert
		else
		{
			String add = "INSERT INTO employee (eid, name, password, gender,email, phno, city) VALUES (?, ?, ?, ?, ?, ?, ?)";
			int insert = template.update(add,emp.getEid(),emp.getName(),emp.getPassword(),emp.getGender(),emp.getEmail(),emp.getPhno(),emp.getCity());
			
			//no of rows affected.
			if(insert>0)
			{
				return "success";
			}
			else 
			{
				return "failure";
			}
		}
		
	}

	@Override
	public String updateEmployee(Employee emp) 
	{
		int count = template.queryForObject("select count(eid) from employee where eid = ?", Integer.class, emp.getEid());
		
		System.out.println("--------------insert select count-------------"+count);
		
		//id found - update
		if(count==1)
		{
			
		// TODO Auto-generated method stub
			String upd = "UPDATE employee SET name=?, password=?, gender=?,email=?, phno=?, city=? WHERE eid=?";
			int updCount=template.update(upd,emp.getName(),emp.getPassword(),emp.getGender(),emp.getEmail(),emp.getPhno(),emp.getCity(),emp.getEid());
		
		//no of rows affected.
			if(updCount>0)
			{
				return "success";
			}
			else
			{
				return "failure";	
			}
		}
		//id not found - cannot update
		else
		{
			return "idnotfound";
		}

	}

	@Override
	public String deleteEmployee(String eid) 
	{
		// TODO Auto-generated method stub
		String del = "DELETE FROM employee WHERE eid=?";
	    int delcount=template.update(del, eid);
	    if(delcount!=0)
	    {
	    	return "success"; 	
	    }
	    else
	    {
	    	return "failure";
	    }
	    
	}

	@Override
	public List<Employee> viewEmployee() 
	{
		// TODO Auto-generated method stub
		String selectAll = "SELECT eid,name,gender,email,phno,city from employee order by name";
	    List<Employee> employeeList = template.query(selectAll, new RowMapper<Employee>() 
	    {
	 
	        @Override
	        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException 
	        {
	            Employee emp = new Employee();
	            emp.setEid(rs.getString(1));
	            emp.setName(rs.getString(2));    
	            emp.setGender(rs.getString(3));
	            emp.setEmail(rs.getString(4));
	            emp.setPhno(rs.getString(5));
	            emp.setCity(rs.getString(6));
	 
	            return emp;
	        }
	 
	    });
	    for (Employee empdet : employeeList) 
	    {
	    	System.out.println(empdet.toString());	    	 
	    }
	    return employeeList;

	}
	
	
	@Override
	public List<Employee> viewEmployeeById (String eid) 
	{
		String selectById = "SELECT eid,name,email,gender,phno,city FROM employee WHERE eid=?";
		List<Employee> employeeListId = template.query(selectById, new Object[] { eid }, new RowMapper<Employee>() 
		{

				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException 
				{
					Employee emp = new Employee();
		            emp.setEid(rs.getString("eid"));
		            emp.setName(rs.getString("name"));
		            emp.setEmail(rs.getString("email"));
		            emp.setGender(rs.getString("gender"));
		            emp.setPhno(rs.getString("phno"));
		            emp.setCity(rs.getString("city"));
		            return emp;
				}

		 });
		 for (Employee empdet : employeeListId) 
		 {
		    	System.out.println(empdet.toString());	    	 
		 }
		 
		 return employeeListId;
	
	}


}

