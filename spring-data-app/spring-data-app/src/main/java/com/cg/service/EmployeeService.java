package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Employee;
import com.cg.repo.IEmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private IEmployeeRepo erepo;

	public String createEmployee(Employee emp) {
		Employee e = erepo.saveAndFlush(emp);
		return "Employee Created! Your Empid is " + e.getEmpid();
	}

	public List<Employee> getAllEmployee() {
		return erepo.findAll();
	}

	public Employee getEmployee(int id) {
		Optional<Employee> op = erepo.findById(id);
		if (op.isPresent())
			return op.get();
		else
			return null;
	}

	public String removeEmployee(int empid) {
		if (getEmployee(empid) != null) {
			erepo.deleteById(empid);
			return "Employee Deleted";
		} else {
			return "Employee Not Found";
		}
	}

	public String updateEmployee(Employee e) {
		erepo.saveAndFlush(e);
		return "Employee Updated";
	}
	
	public List<Employee> getEmployeeByName(String name) {
		return erepo.findByName(name);
	}
	public List<Employee> getEmployeeBySalary(double sal) {
		return erepo.findBySalaryLessThan(sal);
	}
}
