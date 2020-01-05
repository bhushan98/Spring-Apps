package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.entity.Product;
import com.cg.exception.ProductNotFound;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private EntityManager mgr;

	@Override
	public List<Product> listAll() {
		return mgr.createNamedQuery("allProducts").getResultList();
	}

	@Override
	public List<Product> byCategory(String cat) {
		return mgr.createNamedQuery("byCategory").setParameter("cat", cat).getResultList();
	}

	@Override
	public Product addProduct(Product product) {
		mgr.persist(product);
		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		mgr.merge(product);
		return product;
	}

	@Override
	public boolean removeProduct(int id) throws ProductNotFound {
		Product p = mgr.find(Product.class, id);
		if(p == null)
			throw new ProductNotFound("Product with ID: " + id + " not found" );
		mgr.remove(p);
		return true;
	}

	@Override
	public Product fetchById(int id) throws ProductNotFound {
		Product p = mgr.find(Product.class, id);
		if(p == null)
			throw new ProductNotFound("Product with ID: " + id + " not found");
		return p;
	}

	@Override
	public List<Product> sortByPrice() {
		return mgr.createNamedQuery("sortByPrice").getResultList();
	}

}
