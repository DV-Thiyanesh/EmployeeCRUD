package com.app.employeedetails.validator;

import java.util.ArrayList;
import java.util.List;
import com.app.employeedetails.model.EmpErrorMsg;
import com.app.employeedetails.model.Employee;

public class EmployeeValidator 

{

	public static List<EmpErrorMsg> empvalidation(Employee empDet)
	{
		List<EmpErrorMsg> listErrorMsg=new ArrayList<EmpErrorMsg>();
		
		EmpErrorMsg idErrorMsgEmpty=new EmpErrorMsg();
		
	
		if(empDet.getEid().isEmpty())
		{
			System.out.println("--------------"+empDet.getEid());
			idErrorMsgEmpty.setMsgcode("EIDFILL");
			idErrorMsgEmpty.setMsg("Please fill the Employee Id.");	
			listErrorMsg.add(idErrorMsgEmpty);
		}
		else if(!empDet.getEid().matches("^[A-Z]{4}[0-9]{3}$"))
		{
			EmpErrorMsg idErrorMsgPattern=new EmpErrorMsg();
			//System.out.println("---------------empid(PRINT1)--------------------"+emp.getEid());
			idErrorMsgPattern.setMsgcode("EIDFILL");
			idErrorMsgPattern.setMsg("Please Enter a Valid Employee Id");
			listErrorMsg.add(idErrorMsgPattern);
		}
		
		
		
		if(empDet.getName().isEmpty())
		{
			EmpErrorMsg nameErrorMsgEmpty=new EmpErrorMsg();
			nameErrorMsgEmpty.setMsgcode("NAMFILL");
			nameErrorMsgEmpty.setMsg("Please fill the Name.");
			listErrorMsg.add(nameErrorMsgEmpty);
		}
		else if(!empDet.getName().matches("^[A-Za-z ']+$"))
		{
			EmpErrorMsg nameErrorMsgPattern=new EmpErrorMsg();
			nameErrorMsgPattern.setMsgcode("NAMFILL");
			nameErrorMsgPattern.setMsg("Please Enter a valid name.");
			listErrorMsg.add(nameErrorMsgPattern);
		}
		
		EmpErrorMsg pwdErrorMsgEmpty=new EmpErrorMsg();
		
		if(empDet.getPassword().isEmpty())
		{
			pwdErrorMsgEmpty.setMsgcode("KEYFILL");
			pwdErrorMsgEmpty.setMsg("Please fill the Password.");
			listErrorMsg.add(pwdErrorMsgEmpty);
		}
		else if(!empDet.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d.*)(?=.*\\W.*)[a-zA-Z0-9\\S]{8,15}$"))
		{
			EmpErrorMsg pwdErrorMsgPattern=new EmpErrorMsg();
			pwdErrorMsgPattern.setMsgcode("KEYFILL");
			pwdErrorMsgPattern.setMsg("Please Enter a valid and strong password.");
			listErrorMsg.add(pwdErrorMsgPattern);
		}
		
		EmpErrorMsg emailErrorMsgEmpty=new EmpErrorMsg();
		
		if(empDet.getEmail().isEmpty())
		{
			emailErrorMsgEmpty.setMsgcode("EMLFILL");
			emailErrorMsgEmpty.setMsg("Please fill the EmailId.");
			listErrorMsg.add(emailErrorMsgEmpty);
		}
		else if(!empDet.getEmail().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
		{
			EmpErrorMsg emailErrorMsgPattern=new EmpErrorMsg();
			emailErrorMsgPattern.setMsgcode("EMLFILL");
			emailErrorMsgPattern.setMsg("Please Enter a Valid EmailId.");
			listErrorMsg.add(emailErrorMsgPattern);
		}
		
		EmpErrorMsg phnoErrorMsgEmpty=new EmpErrorMsg();
		
		if(empDet.getPhno().isEmpty())
		{
			phnoErrorMsgEmpty.setMsgcode("PHNFILL");
			phnoErrorMsgEmpty.setMsg("Please fill the Phone Number.");
			listErrorMsg.add(phnoErrorMsgEmpty);
		}
		else if(!empDet.getPhno().matches("^((\\+){1}91){1}[1-9]{1}[0-9]{9}$"))
		{
			EmpErrorMsg phnoErrorMsgPattern=new EmpErrorMsg();
			phnoErrorMsgPattern.setMsgcode("PHNFILL");
			phnoErrorMsgPattern.setMsg("Please Enter a valid Phone Number.");
			listErrorMsg.add(phnoErrorMsgPattern);
		}
		
		EmpErrorMsg genderErrorMsgEmpty=new EmpErrorMsg();
		
		if(empDet.getGender().isEmpty())
		{
			genderErrorMsgEmpty.setMsgcode("GENFILL");
			genderErrorMsgEmpty.setMsg("Please Select the Gender.");
			listErrorMsg.add(genderErrorMsgEmpty);
		}
		
		EmpErrorMsg cityErrorMsgEmpty=new EmpErrorMsg();
		
		if(empDet.getCity().isEmpty())
		{
			cityErrorMsgEmpty.setMsgcode("CTYFILL");
			cityErrorMsgEmpty.setMsg("Please Select the City.");
			listErrorMsg.add(cityErrorMsgEmpty);
		}
		
		System.out.println("--------------Message--------------  "+listErrorMsg.size());
		return listErrorMsg;
		
	}
	

}
