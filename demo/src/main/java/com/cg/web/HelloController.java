package com.cg.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello and Welcome to Spring Boot";
	}
	
	@GetMapping(value = "/greet", produces = "text/html")
	public String sayHi(@RequestParam("name") String name) {
		return "<h1>Hello " + name + " and Welcome to Spring Boot</h1>";
	}
	
	@GetMapping(value = "/namaste/{name}", produces = "application/json")
	public String sayNamaste(@PathVariable String name) {
		return "{ \"name\" : \""+ name  + "\", \"message\": \"namaste\"}";
	}
	
}
