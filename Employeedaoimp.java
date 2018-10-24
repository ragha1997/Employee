package com.capgemini.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.dto.EmployeeDto;

import com.capgemini.utils.DBUtils;

public class Employeedaoimp implements Employeedao {

	private Connection dbConnection;	// ???
	
	{
		
		try {
			dbConnection = DBUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public EmployeeDto findById(int id) {
		// TODO Auto-generated method stub

		String selectQuery = "select * from employ where empId = ?";
		
		try {
			PreparedStatement selectStatement = dbConnection.prepareStatement(selectQuery);
					
			selectStatement.setInt(1, id);
			
			ResultSet result = selectStatement.executeQuery();
			
			while(result.next()){
				
				int empId = result.getInt(1);
				Date joinDateSQL =  result.getDate(2);
				String name= result.getString(3);
				java.util.Date joinDate = new java.util.Date(joinDateSQL.getTime());
				
				EmployeeDto edto = new EmployeeDto();
				edto.setEmployeeid(empId);
				edto.setJoinDate(joinDate);
				edto.setName(name);
				return edto;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	
	}

	@Override
	public boolean createEmployee(EmployeeDto emp) {
		// TODO Auto-generated method stub
		String insertQuery = "insert into employ(empId,joinDate,name)  values(empId.nextval,?,?)";
		try {
			PreparedStatement nam=dbConnection.prepareStatement(insertQuery);

			nam.setString(2, emp.getName());
			
			Date joinDate = new Date(emp.getJoinDate().getTime());
			
			nam.setDate(1, joinDate);
			
			int rows = nam.executeUpdate();
			if(rows>0){
				return true;
			}else return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
		
	}

}
