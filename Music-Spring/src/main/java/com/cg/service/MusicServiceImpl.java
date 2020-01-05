package com.cg.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Album;
import com.cg.entity.Artist;
import com.cg.repo.MusicRepo;

@Service
@Transactional
public class MusicServiceImpl implements MusicService{
	
	@Autowired
	private MusicRepo repo;
	
	public int add(Object obj) {
		return repo.save(obj);
	}

	public List<Artist> fetchAllArtists() {
		return repo.fetchAllArtists();
	}

	public List<Album> fetchAllAlbums() {
		return repo.fetchAllAlbums();
	}

	public Set<Album> findAlbumByArtist(String name) {
		return repo.findAlbumByArtist(name);
	}

}
