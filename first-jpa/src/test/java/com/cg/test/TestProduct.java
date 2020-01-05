package com.cg.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.entity.Product;

public class TestProduct {
	private EntityManager mgr;
	
	@Before
	public void setup() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyJPA");
		mgr = factory.createEntityManager();
	}
	
	@After
	public void tearDown() {
		mgr.close();
	}
	
	@Test
	public void testSaveProduct() {
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		Product p = new Product();
		p.setName("iPhone");
		p.setPrice(69999.99);
		p.setStock(25);
		mgr.persist(p);
		txn.commit();
		
	}
	
	@Test
	public void testDetached() {
		EntityTransaction txn = mgr.getTransaction();
		txn.begin();
		Product p = (Product) mgr.find(Product.class, 10);
		txn.commit();
		txn.begin();
		p.setStock(600);
		txn.commit();
	}
	
	@Test
	public void tesFetchProducts() {
		Query que = mgr.createQuery("from Product where price > :pr");
		que.setParameter("pr", 5000.00);
		List<Product> products = que.getResultList();
		for(Product p : products ) {
			System.out.println(p.getName());
		}
	}
	
	@Test
	public void testNameQuery() {
		Query que = mgr.createNamedQuery("stockQuery");
		que.setParameter("st", 10);
		List<Product> products = que.getResultList();
		for(Product p : products ) {
			System.out.println(p.getName());
		}
	}
}
