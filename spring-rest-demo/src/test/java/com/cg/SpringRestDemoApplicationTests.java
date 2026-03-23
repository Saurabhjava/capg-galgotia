package com.cg;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dao.IEmployeeRepo;
import com.cg.dto.EmployeeDTO;
import com.cg.dto.EntityMapper;
import com.cg.entity.Employee;
import com.cg.exception.EmployeNotFoundException;
import com.cg.service.EmployeeService;
import com.cg.service.IEmployeeService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SpringRestDemoApplicationTests {
	
	@Mock
	private IEmployeeRepo repo;
	@InjectMocks
	private EmployeeService service;
	
//	@Test
//	void testEmployeeById() {
//		assertNotNull(service.getEmployee(152));
//		assertThrows(EmployeNotFoundException.class,()->service.getEmployee(220));
//		assertEquals("Astam", service.getEmployee(204).getFullName());
//	}
	
	@Test
	void testEmployeeById() {
		EmployeeDTO edDto=new EmployeeDTO("Ragav", LocalDate.of(2002, 10, 12), 34000.00);
		edDto.setEmployeeId(1001);
		Employee emp=EntityMapper.convertObjectToEntity(edDto);
		Optional<Employee> op=Optional.of(emp);
		when(repo.findById(1001)).thenReturn(op);
		assertNotNull(service.getEmployee(1001));
		assertEquals("Ragav", service.getEmployee(1001).getFullName());
	}
	
	@Test
	void testEmployeeByIdWithException() {
		
		when(repo.findById(1002)).thenThrow(EmployeNotFoundException.class);
		assertThrows(EmployeNotFoundException.class,()->service.getEmployee(1002));
	}
	
	@Test
	void testCreateEmployee() {
		EmployeeDTO edto=new EmployeeDTO("Saurabh", LocalDate.of(1985, 10, 12), 10000.00);
		Employee output=EntityMapper.convertObjectToEntity(edto);
		when(repo.saveAndFlush(any(Employee.class))).thenReturn(output);
		
		EmployeeDTO result=service.createEmployee(edto);
		System.out.println("------>"+result);
		assertNotNull(result);
	}
}
