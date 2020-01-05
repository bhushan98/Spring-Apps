package com.cg.repo;

import java.util.List;
import java.util.Set;

import com.cg.entity.Album;
import com.cg.entity.Artist;

public interface MusicRepo {
	
	int save(Object obj);
	
	List<Artist> fetchAllArtists();
	
	List<Album> fetchAllAlbums();
	
	Set<Album> findAlbumByArtist(String name);
	
}
