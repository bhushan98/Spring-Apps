package com.cg.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "artid", sequenceName = "artist_seq")
public class Artist {
	@Id
	@GeneratedValue(generator = "artid")
	@Column(name = "artid")
	private int id;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String genre;
	
	@OneToMany(mappedBy = "artist", cascade = CascadeType.MERGE, fetch = FetchType.EAGER )
	Set<Album> albums = new HashSet<Album>();

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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

}
