package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer>{
	
	@Query("SELECT m FROM Movie m")
	List<Movie> getAllMovies();
	
	@Query("SELECT m FROM Movie m WHERE genre=:gen")
	List<Movie> getByGenre(String gen);
	
}
