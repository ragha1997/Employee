package com.capgemini.dto;

import java.util.Date;

public class EmployeeDto {
	private int employeeid;
	private Date joinDate;
	private String name;

	
//	PROPERTIES
public void setEmployeeid(int employeeid) {
	this.employeeid = employeeid;
}
public int getEmployeeid() {
	return employeeid;
}
public void setJoinDate(Date joinDate) {
	this.joinDate = joinDate;
}
public Date getJoinDate() {
	return joinDate;
}
public void setName(String name) {
	this.name = name;
}
public String getName() {
	return name;
}
}
