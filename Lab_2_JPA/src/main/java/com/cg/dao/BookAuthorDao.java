package com.cg.dao;

import java.util.List;

import com.cg.entity.Book;

public interface BookAuthorDao {
	
	void save(Object o);
	
	List<Book> fetchAll();
	
	List<Book> fetchByAuthor(String authorName);
	
	List<Book> fetchByPrice(double min, double max);
	
	String getAuthorName(int bookId);
	
}
