package com.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "albid", sequenceName = "album_seq")
public class Album {
	@Id
	@GeneratedValue(generator = "albid")
	private int albumId;
	@Column(length = 20)
	private String title;
	private double price;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private Artist artist;

	public int getId() {
		return albumId;
	}

	public void setId(int id) {
		this.albumId = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "Album [albumId=" + albumId + ", title=" + title + ", price=" + price + ", artist=" + artist + "]";
	}
	
}
