package com.cg.test;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.entity.Album;
import com.cg.entity.Artist;
import com.cg.service.MusicService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestMusic {
	
	@Autowired
	private MusicService service;
	
	@Test
	public void testAddArtist() {
		Artist a = new Artist();
		a.setName("A R Rehman");
		a.setGenre("Classical");
		
		service.add(a);
	}
	
	@Test
	public void testCascadeAdd() {
		Artist a = new Artist();
		a.setName("Dram");
		a.setGenre("Rap");
		
		Album a1 = new Album();
		a1.setTitle("N 1");
		a1.setPrice(12123.22);
		a1.setArtist(a);
		
		Album a2 = new Album();
		a2.setTitle(" vol 2");
		a2.setPrice(213.22);
		a2.setArtist(a);
		
		a.getAlbums().add(a1);
		a.getAlbums().add(a2);
		
		service.add(a);
	}
	
	@Test
	public void testFetchAlbum() {
		List<Album> albums = service.fetchAllAlbums();
		for (Album album : albums) {
			System.out.println(album);
		}
	}
	
	@Test
	public void testFetchArtist() {
		List<Artist> artists = service.fetchAllArtists();
		for (Artist artist : artists) {
			System.out.println(artist);
		}
	}
	
	@Test
	public void testFetchAlbumByAuthor() {
		Set<Album> albums = service.findAlbumByArtist("Ram");
		for (Album album : albums) {
			System.out.println(album);
		}
	}
}
