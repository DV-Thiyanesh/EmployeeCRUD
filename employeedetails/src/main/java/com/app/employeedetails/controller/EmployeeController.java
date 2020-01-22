package com.app.employeedetails.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.app.employeedetails.model.EmpDataTableView;
import com.app.employeedetails.model.EmpErrorMsg;
import com.app.employeedetails.model.Employee;
import com.app.employeedetails.model.EmpViewErrorMsg;
import com.app.employeedetails.service.EmployeeImplService;
import com.app.employeedetails.validator.EmployeeValidator;

	@Controller
	public class EmployeeController 
	{
		
		@Autowired
		private EmployeeImplService empService;
		
		
	    @RequestMapping(value="/employeedetails")
		public String displayForm(Model model) 
		{
			Employee e=new Employee();
			model.addAttribute("employee",e);
			return "EmployeeForm";
			
		}
	    /*
		@ModelAttribute("Employee")
  		public Employee display() 
  		{
    		Employee empDet = new Employee();
		    empDet.setEid(eid);
			empDet.setName(name);
		    empDet.setPassword(password);
		    empDet.setPhno(phno);
		    empDet.setCity(city);
		    empDet.setEmail(email);
		    empDet.setGender(gender);
		    return empDet;
  		}
		 
			
		@RequestMapping("/employeedetails")
		public String displayForm() 
		{	
			return "EmployeeForm";	
		}
		*/
	    
		@PostMapping(value="/employeedetails/saveemployee",produces="application/json" )
		public @ResponseBody EmpViewErrorMsg addEmployee(@RequestParam String eid,@RequestParam String name,@RequestParam String password,
				 @RequestParam String gender,@RequestParam String phno,@RequestParam String email,@RequestParam String city) throws SQLException 
		
		{
			System.out.println("------------------ENTERED ADD EMPLOYEE----------------");
			System.out.println("----------oneeeeeeeee----------"+eid);
			Employee empDet= new Employee();
			empDet.setEid(eid);
			empDet.setName(name);
		    empDet.setPassword(password);
		    empDet.setPhno(phno);
		    empDet.setCity(city);
		    empDet.setEmail(email);
		    empDet.setGender(gender);
		    
		    System.out.println("----------oneeeeeeeee----------"+empDet.toString());

			List<EmpErrorMsg> errorMsgVd=new ArrayList<EmpErrorMsg>();
			errorMsgVd=EmployeeValidator.empvalidation(empDet);
			
			System.out.println("----------validation----------"+errorMsgVd.toString());
			
			if(errorMsgVd.isEmpty())
			{
				 List<EmpErrorMsg> errorMsgDb=new ArrayList<EmpErrorMsg>();
				 errorMsgDb=empService.addEmployee(empDet);
				 if(errorMsgDb.isEmpty())
				 {
					 EmpViewErrorMsg viewErrorMsgDb=new EmpViewErrorMsg();
					 viewErrorMsgDb.setAction("DBCODE");
					 viewErrorMsgDb.setMsg("Insertion Success");	
					 viewErrorMsgDb.setLstErrorMsg(errorMsgDb);
					 return viewErrorMsgDb;
				 }
				 
				 else
				 {
					 EmpViewErrorMsg viewErrorMsgDb1=new EmpViewErrorMsg();
					 viewErrorMsgDb1.setAction("DBCODE");
					 viewErrorMsgDb1.setMsg("Insertion Failed");	
					 viewErrorMsgDb1.setLstErrorMsg(errorMsgDb);
					 return viewErrorMsgDb1;
				 }	
				   
			}
			else
			{
				EmpViewErrorMsg viewErrorMsgVd=new EmpViewErrorMsg();
				viewErrorMsgVd.setAction("VDCODE");
			    viewErrorMsgVd.setMsg("Validation Error");	
			    viewErrorMsgVd.setLstErrorMsg(errorMsgVd);
			    return viewErrorMsgVd;
			}
			
			
		 } 
		
		 @PutMapping(value="/employeedetails/updateemployee/{eid}",produces="application/json")
		 public @ResponseBody EmpViewErrorMsg updateEmployee(@PathVariable("eid") String eid,@RequestParam String name,@RequestParam String password,
				 @RequestParam String gender,@RequestParam String phno,@RequestParam String email,@RequestParam String city) throws JsonProcessingException 
		 {  
			    Employee empDet=new Employee();
			    empDet.setEid(eid); 
			    System.out.println("-----------------------------------update-------"+eid);
				empDet.setName(name);
			    empDet.setPassword(password);
			    empDet.setPhno(phno);
			    empDet.setCity(city);
			    empDet.setEmail(email);
			    empDet.setGender(gender);
			   
			    
			    List<EmpErrorMsg> errorMsgVd=new ArrayList<EmpErrorMsg>();
				errorMsgVd=EmployeeValidator.empvalidation(empDet);

				if(errorMsgVd.isEmpty())
				{
					 List<EmpErrorMsg> errorMsgDb=new ArrayList<EmpErrorMsg>();
					 errorMsgDb=empService.updateEmployee(empDet);
					 if(errorMsgDb.isEmpty())
					 {
						 EmpViewErrorMsg viewErrorMsgDb=new EmpViewErrorMsg();
						 viewErrorMsgDb.setAction("DBCODE");
						 viewErrorMsgDb.setMsg("Updation Success");	
						 viewErrorMsgDb.setLstErrorMsg(errorMsgDb);
						 return viewErrorMsgDb;
					 }
					 else
					 {
						 EmpViewErrorMsg viewErrorMsgDb1=new EmpViewErrorMsg();
						 viewErrorMsgDb1.setAction("DBCODE");
						 viewErrorMsgDb1.setMsg("Updation Failed");	
						 viewErrorMsgDb1.setLstErrorMsg(errorMsgDb);
						 return viewErrorMsgDb1;
					 }	
					   
				}
				else
				{
					EmpViewErrorMsg viewErrorMsgVd=new EmpViewErrorMsg();
					viewErrorMsgVd.setAction("VDCODE");
				    viewErrorMsgVd.setMsg("Validation Error");	
				    viewErrorMsgVd.setLstErrorMsg(errorMsgVd);
				    return viewErrorMsgVd;
				}
				
			    
		 }
		 
		 @GetMapping(value="/employeedetails/deleteemployee/{eid}",produces="application/json")
		 public @ResponseBody EmpViewErrorMsg deleteEmployee(@PathVariable("eid") String eid) throws JsonProcessingException 
		 {
			 System.out.println(eid);
			 List<EmpErrorMsg> errorMsgDb=new ArrayList<EmpErrorMsg>();
			 errorMsgDb=empService.deleteEmployee(eid);
			 if(errorMsgDb.isEmpty())
			 {
				EmpViewErrorMsg viewErrorMsgDb=new EmpViewErrorMsg();
				viewErrorMsgDb.setAction("DBCODE");
	            viewErrorMsgDb.setMsg("Deletion Success");	
			    viewErrorMsgDb.setLstErrorMsg(errorMsgDb);
				return viewErrorMsgDb;
			 }
			 else
		     {
				EmpViewErrorMsg viewErrorMsgDb1=new EmpViewErrorMsg();
				viewErrorMsgDb1.setAction("DBCODE");
			    viewErrorMsgDb1.setMsg("Deletion Failed");	
				viewErrorMsgDb1.setLstErrorMsg(errorMsgDb);
				return viewErrorMsgDb1;
			 }	
		 }
		
		 @GetMapping(value= "/employeedetails/employeelist",produces="application/json")
		 public @ResponseBody EmpDataTableView viewEmployee() 
		 {
			List<Employee> dbTable=new ArrayList<Employee>();
			dbTable=empService.viewEmployee();
			EmpDataTableView dbTableListView=new EmpDataTableView();
			dbTableListView.setData(dbTable);
			return dbTableListView;	
		 }
		
		 @GetMapping(value="/employeedetails/employeelist/{eid}",produces="application/json")
		 public @ResponseBody EmpDataTableView viewEmployeeById(@PathVariable("eid") String eid) 
		 {
			 List<Employee> dbTable=new ArrayList<Employee>();
			 dbTable=empService.viewEmployeeById(eid);			 
			 EmpDataTableView dbTableListView=new EmpDataTableView();
			 dbTableListView.setData(dbTable);
			 return dbTableListView;	
		 }
			 	


	}

