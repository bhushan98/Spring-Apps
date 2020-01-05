package com.cg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Product;
import com.cg.exception.ProductNotFound;
import com.cg.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping(value = "/list", produces = "application/json")
	public List<Product> listAllProducts() {
		return service.listAll();
	}
	
	@GetMapping(value = "/category/{cat}", produces = "application/json")
	public List<Product> lisyByCategory(@PathVariable String cat){
		return service.searchByCategory(cat);
	}
	
	@GetMapping(value = "/sortbyprice", produces = "application/json")
	public List<Product> sortByPrice(){
		return service.sortProductsByPrice();
	}
	
	@GetMapping(value = "/id/{id}", produces = "application/json")
	public Product searchById(@PathVariable int id) throws ProductNotFound {
		return service.fetchProductById(id);
	}
	
	@PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
	public Product addProduct(@RequestBody Product product) {
		return service.addNewProduct(product);
	}
	
	@PutMapping(value = "/update", produces = "application/json")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateExistingProduct(product);
	}
	
	@DeleteMapping(value = "/delete")
	public boolean deleteProduct(@RequestParam("id") int id) throws ProductNotFound {
		return service.removeExistingProduct(id);
	}
	
	
}
