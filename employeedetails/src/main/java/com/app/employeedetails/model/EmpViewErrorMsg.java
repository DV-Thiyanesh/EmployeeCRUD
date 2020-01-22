package com.app.employeedetails.model;


import java.util.List;

public class EmpViewErrorMsg 
{
	
	private String action;
	private String msg;
	private List<EmpErrorMsg> lstErrorMsg;
	//private List<EmpCsrfCode> lstCode;
	
	
	public EmpViewErrorMsg()
	{
		
	}
	public EmpViewErrorMsg(String s1, String s2)
	{
		this.action=s1;
		this.msg=s2;
	
		
	}
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) 
	{
		this.action = action;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) 
	{
		this.msg = msg;
	}
	public List<EmpErrorMsg> getLstErrorMsg() 
	{
		return lstErrorMsg;
	}
	public void setLstErrorMsg(List<EmpErrorMsg> lstMsg) 
	{
		this.lstErrorMsg = lstMsg;
	}
	
	
	

}
