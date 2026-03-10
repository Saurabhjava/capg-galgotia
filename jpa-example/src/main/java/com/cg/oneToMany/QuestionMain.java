package com.cg.oneToMany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class QuestionMain {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("my-pu");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
//		Question q=new Question("What is Java?", "M");
//		List<Answer> li=new ArrayList<>();
//		li.add(new Answer("Java is OOP", q));
//		li.add(new Answer("Java is multithreaded",q));
//		li.add(new Answer("Java is Simple",q));
//		q.setAnswer(li);
//		em.persist(q);
//		em.getTransaction().commit();
//		System.out.println("Created.....");
		Question q=em.find(Question.class, 2);
		System.out.println(q.getQuestionName());
		q.getAnswer().forEach(a->System.out.println(a.getAnswer()));
		
		//Answer ans=em.find(Answer.class, 53);
//		System.out.println("=========Answer==========");
//		System.out.println(ans.getAnswer());
//		System.out.println("===========Question==========");
//		System.out.println(ans.getQuestion().getQuestionName());
		em.remove(q);
		em.getTransaction().commit();
	}

}
