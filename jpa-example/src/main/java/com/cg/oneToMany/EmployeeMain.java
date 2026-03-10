package com.cg.oneToMany;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmployeeMain {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("my-pu");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Department dept1=new Department("IT");
		dept1.setEmps(List.of(new Employee("Mahi", "Mahi@gmail.com",dept1),
				new Employee("Raj", "raj@gmail.com",dept1)));
		
		em.persist(dept1);
//		Department dept=em.find(Department.class, 2);
//		dept.setEmps(List.of(new Employee("Ritwik", "ritwik@gmail.com"),
//				new Employee("Vinay", "vinay@gmail.com")));
//		//em.persist(dept);
		em.getTransaction().commit();
		System.out.println("Dept Created");
		

	}

}
