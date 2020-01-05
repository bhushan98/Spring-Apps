package com.cg.service;

import java.util.List;

import com.cg.emtity.Laptop;

public interface LaptopService {
	
	Laptop add(Laptop laptop);
	
	List<Laptop> fetchAll();
	
	Laptop update(Laptop laptop);
	
	Boolean delete(int id);
	
	Laptop fetchById(int id);
}
