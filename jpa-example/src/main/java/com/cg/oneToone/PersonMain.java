package com.cg.oneToone;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonMain {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("my-pu");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
//		Person p=new Person("Ayush", LocalDate.of(2004, 8, 22));
//		Dl obj=new Dl(LocalDate.of(2042, 10, 12), LocalDate.of(2022, 10, 12), "LMV");
//		p.setDl(obj);
//		//em.persist(obj);
//		em.persist(p);
//		em.getTransaction().commit();
		
		Person p=em.find(Person.class, 52);
		System.out.println(p.getName());
		//em.detach(p);
		System.out.println("======DL=========");
		System.out.println(p.getDl());
		em.remove(p);
		System.out.println("Person Removed");
		em.getTransaction().commit();
//		Dl d=em.find(Dl.class, 2);
//		System.out.println(d);
		//System.out.println("Person Created.....");
	}
}
