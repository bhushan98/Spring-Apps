package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.entity.Author;
import com.cg.entity.Book;

public class BookAuthorDaoImpl implements BookAuthorDao {
	private EntityManagerFactory factory;
	
	public BookAuthorDaoImpl() {
		factory = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public void save(Object o) {
		EntityManager mgr = null;
		try {
			mgr = factory.createEntityManager();
			EntityTransaction txn = mgr.getTransaction();
			txn.begin();
			mgr.persist(o);
			txn.commit();
		} finally {
			mgr.close();
		}
	}
	
	public List<Book> fetchAll() {
		EntityManager mgr = null;
		
		try {
			mgr = factory.createEntityManager();
			Query query = mgr.createQuery("from Book");
			return query.getResultList();
		} finally {
			mgr.close();
		}
	}

	public List<Book> fetchByAuthor(String authorName) {
		EntityManager mgr = null;
		mgr = factory.createEntityManager();
		Query que = mgr.createQuery("from Author where name = :authorName");
		que.setParameter("authorName", authorName);
		Author author = (Author) que.getSingleResult();
		
		Query que1 = mgr.createQuery("from Book where authorId = :a");
		que1.setParameter("a", author.getAuthorId());
		List<Book> books = que1.getResultList();
		return books;
	}

	public List<Book> fetchByPrice(double min, double max) {
		EntityManager mgr = null;
		mgr = factory.createEntityManager();
		Query que = mgr.createQuery("from Book where price between :min and :max");
		que.setParameter("min", min);
		que.setParameter("max", max);
		List<Book> books = que.getResultList();
		return books;
	}

	public String getAuthorName(int bookId) {
		EntityManager mgr = null;
		mgr = factory.createEntityManager();
		Query que = mgr.createQuery("from Book where isbn = :id");
		que.setParameter("id", bookId);
		
		Book book = (Book) que.getSingleResult();
		Author author = mgr.find(Author.class, book.getAuthor().getAuthorId());
		return author.getName();
	}

}
