package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "movies")
@SequenceGenerator(name = "moseq", sequenceName = "seq_movie")
@NamedQuery(name = "allMovies", query = "SELECT m FROM Movie m")
@NamedQuery(name = "byGenre", query = "SELECT m FROM Movie m WHERE m.genre=:gen")
public class Movie {
	@Id
	@GeneratedValue(generator = "moseq")
	private int id;
	@Column(length = 20)
	private String title;
	@Column(length = 10)
	private String genre;
	private int rating;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
}
