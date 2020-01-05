package com.cg.repo;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.entity.Album;
import com.cg.entity.Artist;

import oracle.jdbc.OracleResultSet.AuthorizationIndicator;

@Repository
public class MusicRepoImpl implements MusicRepo {
	
	@PersistenceContext(name = "MyJPA")
	private EntityManager mgr;

	public int save(Object obj) {
		mgr.persist(obj);
		return 0;
	}

	public List<Artist> fetchAllArtists() {
		return mgr.createQuery("from Artist").getResultList();
	}

	public List<Album> fetchAllAlbums() {
		return mgr.createQuery("from Album").getResultList();
	}

	public Set<Album> findAlbumByArtist(String name) {
		Query que = mgr.createQuery("from Artist where name = :n");
		que.setParameter("n", name);
		Artist a = (Artist) que.getSingleResult();
		return a.getAlbums();
	}

}
