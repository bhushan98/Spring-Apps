package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.entity.Trainer;
import com.cg.exception.TrainerNotFound;

@Repository
public class TrainerDaoImpl implements TrainerDao {

	@Autowired
	private EntityManager mgr;
	
	@Override
	public List<Trainer> listAll() {
		return mgr.createNamedQuery("allTrainers").getResultList();
	}

	@Override
	public List<Trainer> listTrainerByStream(String str) {
		return mgr.createNamedQuery("byStream").setParameter("str", str).getResultList();
	}

	@Override
	public Trainer addTrainer(Trainer trainer) {
		mgr.persist(trainer);
		return trainer;
	}

	@Override
	public Trainer updateTrainerDetails(Trainer trainer) {
		return mgr.merge(trainer);
	}

	@Override
	public boolean deleteTrainer(int id) throws TrainerNotFound {
		Trainer t = mgr.find(Trainer.class, id);
		if(t == null)
			throw new TrainerNotFound("Trainer with ID: " + id + "does not exist");
		mgr.remove(t);
		return true;
	}

	@Override
	public Trainer fetch(int id) throws TrainerNotFound {
		Trainer t = mgr.find(Trainer.class, id);
		if(t == null)
			throw new TrainerNotFound("Trainer with ID: " + id + " does not exist");
		else
			return t;
	}

	@Override
	public List<Trainer> fetchByFees(double min, double max) {
		return mgr.createNamedQuery("byFees").setParameter("min", min).setParameter("max", max).getResultList();
	}

}
