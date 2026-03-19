package com.cg;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cg.entity.Employee;
import com.cg.service.EmployeeService;

@SpringBootApplication
public class SpringDataAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(SpringDataAppApplication.class, args);
		EmployeeService es=ctx.getBean(EmployeeService.class);
		//es.getAllEmployee().forEach(e->System.out.println(e));
		//System.out.println(es.removeEmployee(2));
//		Employee e=es.getEmployee(152);
//		if(e!=null) {
//			e.setDob(LocalDate.of(2002,6,21));
//			System.out.println(es.updateEmployee(e));
//		} else {
//			System.out.println("Employee Not Found");
//		}
		//es.getEmployeeByName("Vinay").forEach(e->System.out.println(e));
		es.getEmployeeBySalary(50000).forEach(e->System.out.println(e));
	}

}
