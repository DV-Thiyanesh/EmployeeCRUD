package com.app.employeedetails.model;

public class Employee 
{
	
	private String eid;
	private String name;
	private String email;
	private String password;
	private String phno;
    private String gender;
	private String city;
	
	public Employee()
	{
		
	}
	
	

	public String getEid() 
	{
		return eid;
	}

	public void setEid(String eid) 
	{
		this.eid = eid;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) 
	{
		this.phno = phno;
	}

	public String getGender() 
	{
		return gender;
	}

	public void setGender(String gender) 
	{
		this.gender = gender;
	}

	public String getCity() 
	{
		return city;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}

	@Override
	public String toString() 
	{
		return "employee [eid=" + eid + ", name=" + name + ", email=" + email + ", password=" + password + ", phno="
				+ phno + ", gender=" + gender + ", city=" + city + "]";
	}



}
