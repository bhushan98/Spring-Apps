package com.cg.service;

import java.util.List;

import com.cg.entity.Product;
import com.cg.exception.ProductNotFound;

public interface ProductService {
	
List<Product> listAll();
	
	List<Product> searchByCategory(String cat);
	
	Product addNewProduct(Product product);
	
	Product updateExistingProduct(Product product);
	
	boolean removeExistingProduct(int id) throws ProductNotFound;
	
	Product fetchProductById(int id) throws ProductNotFound;
	
	List<Product> sortProductsByPrice();
}
