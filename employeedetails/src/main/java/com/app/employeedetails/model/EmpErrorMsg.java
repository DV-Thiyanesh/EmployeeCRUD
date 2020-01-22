package com.app.employeedetails.model;

public class EmpErrorMsg 
{
	
	private String msgCode;
	private String msg;

	

	
	public EmpErrorMsg(String s1, String s2)
	{
		this.msgCode=s1;
		this.msg=s2;
		
	}
	
	public EmpErrorMsg() 
	{
		// TODO Auto-generated constructor stub
	}

	public String getMsgcode() 
	{
		return msgCode;
	}
	public void setMsgcode(String msgCode) 
	{
		this.msgCode = msgCode;
	}
	public String getMsg() 
	{
		return msg;
	}
	public void setMsg(String msg) 
	{
		this.msg = msg;
	}

	
}
