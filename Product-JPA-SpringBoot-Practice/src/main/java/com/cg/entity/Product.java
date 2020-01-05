package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "proseq", sequenceName = "pro_seq", allocationSize = 1)
@NamedQuery(name = "allProducts", query = "SELECT p FROM Product p")
@NamedQuery(name = "byCategory", query = "SELECT p FROM Product p WHERE p.category = :cat")
@NamedQuery(name = "byPrice", query = "SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max")
@NamedQuery(name = "sortByPrice", query = "SELECT p FROM Product p ORDER BY p.price")
public class Product {
	
	@Id
	@GeneratedValue(generator = "proseq")
	private int id;
	@Column(length = 20)
	private String name;
	private double rating;
	private int stock;
	private double price;
	@Column(length = 20)
	private String category;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
