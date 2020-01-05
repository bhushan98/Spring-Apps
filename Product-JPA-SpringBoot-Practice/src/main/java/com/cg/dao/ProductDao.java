package com.cg.dao;

import java.util.List;

import com.cg.entity.Product;
import com.cg.exception.ProductNotFound;

public interface ProductDao {
	
	List<Product> listAll();
	
	List<Product> byCategory(String cat);
	
	Product addProduct(Product product);
	
	Product updateProduct(Product product);
	
	boolean removeProduct(int id) throws ProductNotFound;
	
	Product fetchById(int id) throws ProductNotFound;
	
	List<Product> sortByPrice();
} 
