package com.cg.entity;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmployeeMain {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("my-pu");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		//PEmployee obj=new PEmployee();
		CEmployee obj=new CEmployee();
		obj.setName("Abhgyan");
		obj.setDob(LocalDate.of(2002, 11, 17));
		obj.setPay_per_hour(4000);
		em.persist(obj);
		em.getTransaction().commit();
		System.out.println("Created.....");
		
	}

}
