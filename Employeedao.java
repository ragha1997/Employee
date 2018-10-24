package com.capgemini.dao;

import com.capgemini.dto.EmployeeDto;

public interface Employeedao {

	public boolean createEmployee(EmployeeDto Employee);
	public EmployeeDto findById(int id);
	
}
