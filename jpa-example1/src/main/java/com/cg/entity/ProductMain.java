package com.cg.entity;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class ProductMain {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("my-pu");
		EntityManager em=emf.createEntityManager();
		
//		TypedQuery<Product> q=em.createQuery("select p from Product p", Product.class);
//		
//		List<Product> li=q.getResultList();
//		li.forEach(p->System.out.println(p.getName()));
		
//		TypedQuery<Object[]> q=em.createQuery("select p.name, p.price, p.mfd from Product p", Object[].class);
//		
//		List<Object[]> li=q.getResultList();
//		li.forEach(p->System.out.println(p[0]+"\t"+p[1]+"\t"+p[2]));
		
//		TypedQuery<ProductDTO> q=em.createQuery("select new ProductDTO(p.name, p.price, p.mfd) from Product p", ProductDTO.class);
//		
//		List<ProductDTO> li=q.getResultList();
//		li.forEach(p->System.out.println(p));
		
//		TypedQuery<Product> q=em.createQuery("select p from Product p where p.price<:p", Product.class);
//		q.setParameter("p", 80000);
//		List<Product> li=q.getResultList();
//		li.forEach(p->System.out.println(p));
		
//		TypedQuery<Product> q=em.createQuery("select p from Product p where p.name like :p", Product.class);
//		q.setParameter("p", "L%");
//		List<Product> li=q.getResultList();
//		li.forEach(p->System.out.println(p));
		
		em.getTransaction().begin();
//		Query q=em.createQuery("update Product p set p.price=65000 where p.pid=103 ");
//		int row=q.executeUpdate();
//		em.getTransaction().commit();
		Query q=em.createNativeQuery("update product_table p set p.price=55000 where p.pid=103");
		int row=q.executeUpdate();
		System.out.println("Updated ->"+row);
		em.getTransaction().commit();
	}

}
