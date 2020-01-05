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

import com.cg.emtity.Laptop;
import com.cg.service.LaptopService;

@RestController
@RequestMapping("/laptops")
public class LaptopController {
	
	@Autowired
	private LaptopService service;
	
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public Laptop addLaptop(@RequestBody Laptop laptop) {
		return service.add(laptop);
	}
	
	@GetMapping(value = "/find/{id}", produces = "application/json")
	public Laptop findById(@PathVariable int id) {
		return service.fetchById(id);
	}
	
	@GetMapping(value = "/list", produces = "application/json")
	public List<Laptop> fetchAll(){
		return service.fetchAll();
	}
	
	@PutMapping(value = "/update",consumes = "application/json", produces = "application/json")
	public Laptop update(@RequestBody Laptop laptop) {
		return service.update(laptop);
	}
	
	@DeleteMapping(value = "/delete")
	public boolean deleteLaptop(@RequestParam(name = "id" ) int id) {
		return service.delete(id);
	}
}
