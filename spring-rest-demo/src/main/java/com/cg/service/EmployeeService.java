package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IEmployeeRepo;
import com.cg.entity.Employee;

@Service
public class EmployeeService implements IEmployeeService{
	@Autowired
	private IEmployeeRepo repo;
	@Override
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

	@Override
	public Employee createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return repo.saveAndFlush(emp);
	}

	@Override
	public Employee getEmployee(int empid) {
		Optional<Employee> op=repo.findById(empid);
		if(op.isPresent())
			return op.get();
		else
			return null;
	}

	@Override
	public String removeEmployee(int empid) {
		if(getEmployee(empid)!=null) {
			repo.deleteById(empid);
			return "Employee Deleted";
		} else {
			return "Employee Not Found";
		}
	}

	@Override
	public Employee updateEmployee(Employee e) {	
		if(getEmployee(e.getEmpid())!=null)
			return repo.saveAndFlush(e);
		else 
			return null;
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		
		return repo.findByName(name);
	}
	

}
