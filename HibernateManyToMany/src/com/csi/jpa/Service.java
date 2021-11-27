package com.csi.jpa;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Service {
	
	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		
		Product p1 =new Product();
		p1.setProductName("LAPTOP");
		p1.setProductPrise(235544);
		
		
		session.save(p1);
		
		Product p2 =new Product();
		p2.setProductName("TABLET");
		p2.setProductPrise(869944);
		
		session.save(p2);
		
		List<Product> products = new LinkedList<Product>();
		products.add(p1);
		products.add(p2);
		
				
		Company c1 = new Company();
		
		c1.setCompanyName("SAMSUNG");
		c1.setCompanyAdd("PCMC");
		c1.setProducts(products);
		session.save(c1);
		
		Company c2 = new Company();
		
		c2.setCompanyName("NOKIA");
		c2.setCompanyAdd("MUMBAI");
		c2.setProducts(products);
		session.save(c2);
		
		transaction.commit();
	}

}
