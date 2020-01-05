package com.cg.service;

import java.util.List;
import java.util.Set;

import com.cg.entity.Album;
import com.cg.entity.Artist;

public interface MusicService {
	
	int add(Object obj);
	
	List<Artist> fetchAllArtists();
	
	List<Album> fetchAllAlbums();
	
	Set<Album> findAlbumByArtist(String name);
	
}
