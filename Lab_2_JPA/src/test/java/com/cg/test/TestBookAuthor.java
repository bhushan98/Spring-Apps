package com.cg.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.dao.BookAuthorDaoImpl;
import com.cg.entity.Author;
import com.cg.entity.Book;

public class TestBookAuthor {
	private BookAuthorDaoImpl dao;
	
	@Before
	public void init() {
		dao = new BookAuthorDaoImpl();
	}
	
	@After
	public void destory() {
		dao = null;
	}
	
	@Test
	public void testSave() {

		Author a = new Author();
		a.setAuthorId(10);
		a.setName("Rama");
		
		Book b = new Book();
		b.setAuthor(a);
		b.setTitle("OOPS");
		b.setIsbn(12321);
		b.setPrice(1222.12);
		
		dao.save(b);
	}
	
	@Test
	public void testCascadeAdd() {
		Author a = new Author();
		a.setAuthorId(40);
		a.setName("Bhushan");
		
		Book b1 = new Book();
		b1.setIsbn(10026);
		b1.setTitle("JAVA");
		b1.setPrice(7822.99);
		b1.setAuthor(a);
		
		Book b2 = new Book();
		b2.setIsbn(10027);
		b2.setTitle("JPA");
		b2.setPrice(2100.23);
		b2.setAuthor(a);
		
		a.getBooks().add(b1);
		a.getBooks().add(b2);
		
		dao.save(a);
	}
	
	@Test
	public void testFetchAll() {
		List<Book> books = new ArrayList<Book>();
		books = dao.fetchAll();
		for (Book book : books) {
			System.out.println(book);
		}
	}
	
	@Test
	public void testFetchByAuthor() {
		List<Book> result = dao.fetchByAuthor("Bhushan");
		for (Book book : result) {
			System.out.println(book);
		}
	}
	
	@Test
	public void testFetchByPrice() {
		List<Book> result = dao.fetchByPrice(1000, 2000);
		for (Book book : result) {
			System.out.println(book);
		}
	}
	
	@Test
	public void testFetchAuthorById() {
		String name = dao.getAuthorName(10026);
		System.out.println(name);
	}
}
