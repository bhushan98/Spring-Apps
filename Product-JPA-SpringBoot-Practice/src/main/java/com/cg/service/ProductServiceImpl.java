package com.cg.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.ProductDao;
import com.cg.entity.Product;
import com.cg.exception.ProductNotFound;

@Service
@Transactional(rollbackFor = ProductNotFound.class)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public List<Product> listAll() {
		return dao.listAll();
	}

	@Override
	public List<Product> searchByCategory(String cat) {
		return dao.byCategory(cat);
	}

	@Override
	public Product addNewProduct(Product product) {
		return dao.addProduct(product);
	}

	@Override
	public Product updateExistingProduct(Product product) {
		return dao.updateProduct(product);
	}

	@Override
	public boolean removeExistingProduct(int id) throws ProductNotFound {
		return dao.removeProduct(id);
	}

	@Override
	public Product fetchProductById(int id) throws ProductNotFound {
		return dao.fetchById(id);
	}

	@Override
	public List<Product> sortProductsByPrice() {
		return dao.sortByPrice();
	}

}
