package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Employee;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee,Integer> {
//	@Query("select e from Employee e where e.name=:n")
//	public List<Employee> findByNa(@Param("n") String name);
	
	public List<Employee> findByName(String name);
	public List<Employee> findBySalaryLessThan(double salary);
	public List<Employee> findByNameAndSalary(String name, double salary);
}
