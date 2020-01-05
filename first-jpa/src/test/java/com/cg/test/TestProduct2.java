package com.cg.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.cg.entity.Product;

public class TestProduct2 {
	@Test
	public void testDetached() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyJPA");
		EntityManager mgr = factory.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		txn.begin();
		Product p = (Product) mgr.find(Product.class, 9);
		txn.commit();
		mgr.close();
		
		mgr = factory.createEntityManager();
		txn = mgr.getTransaction();
		txn.begin();
		p.setStock(600);
		mgr.merge(p);	// To update existing entity to table
		txn.commit();
		mgr.close();
	}
	
	@Test
	public void testMerge() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyJPA");
		EntityManager mgr = factory.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		txn.begin();
		Product p = new Product();
		p.setCode(9);
		p.setName("Redmi");
		p.setPrice(5000);
		p.setStock(25);
		mgr.merge(p);
		txn.commit();
		mgr.close();
	}
}
