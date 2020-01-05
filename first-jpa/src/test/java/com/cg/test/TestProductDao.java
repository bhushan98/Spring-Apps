package com.cg.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.dao.ProductDao;
import com.cg.dao.ProductDaoImpl;
import com.cg.entity.Product;

public class TestProductDao {
	private ProductDao dao;
	
	@Before
	public void init() {
		dao = new ProductDaoImpl();
	}
	
	@After
	public void destroy() {
		dao = null;
	}
	
	@Test
	public void testSave() {
		Product p = new Product();
		p.setName("Mi A3");
		p.setPrice(13999.99);
		p.setStock(30);
		int code = dao.save(p);
		assertNotNull(code);
	}
	
	@Test
	public void testSearch() {
		Product p = dao.fetch(1);
		System.out.println(p);
		assertNotNull(p);
	}
	
	@Test
	public void testDelete() {
		assertTrue(dao.delete(6));
	}
}
