package manyTomany;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class StudentMain {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("my-pu");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Student s=new Student("Naveen");
		
		Course c=new Course("Java");
		Course c1=new Course("Spring");
		em.persist(c);
		em.persist(c1);
		Set<Course> li=new HashSet<Course>();
		li.add(c);
		li.add(c1);
	
		s.setCourses(li);
		
		em.persist(s);
		System.out.println("Created......");
		em.getTransaction().commit();
	}

}
