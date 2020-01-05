package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.entity.Movie;
import com.cg.exception.InvalidMovieException;
import com.cg.repo.MovieDao;
import com.cg.repo.MovieDaoImpl;

public class MovieDaoServiceImpl implements MovieService {
	
	@Autowired
	private MovieDao dao;
	
	public MovieDaoServiceImpl() {
		dao = new MovieDaoImpl();
	}

	@Override
	public Movie save(Movie movie) {
		
		return dao.save(movie);
	}

	@Override
	public Movie fetch(int id) throws InvalidMovieException {
		return dao.fetch(id);
	}

	@Override
	public List<Movie> getAll() {
		return dao.getAll();
	}

	@Override
	public boolean delete(int id) throws InvalidMovieException {
		return dao.delete(id);
	}

	@Override
	public Movie update(Movie movie) {
		return dao.update(movie);
	}

	@Override
	public List<Movie> byGenre(String gen) {
		return dao.byGenre(gen);
	}

}
