package com.cg.main;

import java.time.LocalDate;
import java.util.List;

import com.cg.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Main {
	public static void main(String[] args) {
		Product p=new Product("Book", 500, 100, LocalDate.of(2024, 10, 15));
		//p.setPid(1003);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("my-pu");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("Created.......");
		
	}
}
