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

import com.cg.entity.Movie;
import com.cg.exception.InvalidMovieException;
import com.cg.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public Movie getMovie(@PathVariable int id) throws InvalidMovieException {
		return service.fetch(id);
	}
	
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json" )
	public Movie saveMovie(@RequestBody Movie movie) {
		return service.save(movie);
	}
	
	@GetMapping(produces = "application/json")
	public List<Movie> getAllMovies() {
		return service.getAll();
	}
	
	@DeleteMapping(value = "/remove")
	public boolean deleteMovie(@RequestParam("id") int id) throws InvalidMovieException {
		return service.delete(id);
	}
	
	@PutMapping(value = "/update",consumes = "application/json", produces = "application/json")
	public Movie updateMovie(@RequestBody Movie movie) {
		return service.update(movie);
	}
	
	@GetMapping(value = "/genre/{genre}", produces = "application/json")
	public List<Movie> fetchByGenre(@PathVariable String genre){
		return service.byGenre(genre);
	}
}  
