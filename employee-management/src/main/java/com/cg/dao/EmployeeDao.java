package com.cg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.cg.bean.Employee;

public class EmployeeDao implements IEmployeeDao{
	private static Connection con;
	static {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String saveEmployee(Employee emp) {
		try {
			PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?)");
			ps.setString(1, emp.getEmpid());
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getDob());
			int rows=ps.executeUpdate();
			if(rows>0)
				return "Employee Created";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Employee Not Created";
	}

	@Override
	public Employee findEmployee(int empid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateEmployeeName(int empid, String newName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

}
